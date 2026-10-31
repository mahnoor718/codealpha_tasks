

from scapy.all import sniff, IP, TCP, UDP, ICMP, ARP

# Detect the packet protocol
def detect_protocol(packet):
    if packet.haslayer(TCP):
        return "TCP"
    elif packet.haslayer(UDP):
        return "UDP"
    elif packet.haslayer(ICMP):
        return "ICMP"
    elif packet.haslayer(ARP):
        return "ARP"
    else:
        return "Other"


# Process each captured packet
def process_packet(packet):
    print("\nPacket Captured")
    print("-" * 45)

    # Get source and destination IP
    if packet.haslayer(IP):
        source_ip = packet[IP].src
        destination_ip = packet[IP].dst

    elif packet.haslayer(ARP):
        source_ip = packet[ARP].psrc
        destination_ip = packet[ARP].pdst

    else:
        source_ip = "N/A"
        destination_ip = "N/A"

    # Detect protocol
    protocol = detect_protocol(packet)

    # Default port values
    source_port = "N/A"
    destination_port = "N/A"

    # Get TCP ports
    if packet.haslayer(TCP):
        source_port = packet[TCP].sport
        destination_port = packet[TCP].dport

    # Get UDP ports
    elif packet.haslayer(UDP):
        source_port = packet[UDP].sport
        destination_port = packet[UDP].dport

    # Packet size in bytes
    packet_size = len(packet)

    # Display packet information
    print("Source IP:", source_ip)
    print("Destination IP:", destination_ip)
    print("Protocol:", protocol)
    print("Source Port:", source_port)
    print("Destination Port:", destination_port)
    print("Packet Size:", packet_size, "bytes")
    print("-" * 45)


# Main program
def main():
    print("=" * 45)
    print("       NETWORK SNIFFER PROJECT")
    print("=" * 45)
    print("Capturing 10 packets...")
    print("Press Ctrl+C to stop if needed.")
    print("-" * 45)

    try:
        sniff(
            count=10,
            prn=process_packet,
            store=False
        )

        print("\nSniffing Completed!")

    except PermissionError:
        print("\nError: Permission denied.")
        print("Try running VS Code as Administrator.")

    except KeyboardInterrupt:
        print("\nSniffing stopped by user.")

    except Exception as error:
        print("\nAn error occurred:", error)


if __name__ == "__main__":
    main()

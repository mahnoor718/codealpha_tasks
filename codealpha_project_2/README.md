# CodeAlpha_PhishingAwareness

- **Name:** Mahnoor Saghir
- **Internship:** CodeAlpha, Cyber Security
- **Task:** Task 2, Phishing Awareness Training

---

## About Task 2

**Task 2: Phishing Awareness Training** asks interns to create a presentation or online module that teaches people about phishing attacks. The module should:

- Explain how to recognize phishing emails and fake websites
- Educate about the social engineering tactics attackers use
- Provide best practices and tips to avoid falling victim
- Include real-world examples and interactive quizzes for better engagement

## About this project

**PhishGuard** is an interactive phishing awareness platform built as my submission for Task 2. It works as an online module: it teaches the concepts, lets users practice on suspicious emails and URLs, and tests their knowledge with a quiz.

Everything runs in the browser, so there is nothing to install.

---

## Features

| Section | What it does |
|---|---|
| **Dashboard** | Shows total scans, low-risk and high-risk counts, latest quiz score, a risk chart and recent activity. |
| **Email Analyzer** | Paste an email subject, sender and body. It checks for common phishing signs and gives a risk score out of 100 with an explanation for each finding. Includes a demo email. |
| **URL Analyzer** | Checks a web address for suspicious patterns (see below) without opening the site or contacting any server. Includes a demo URL. |
| **Scan History** | Saves your past scans in the browser, shows them in a table and lets you export them as JSON or clear them. |
| **Awareness Guide** | Explains phishing, spear phishing, smishing, vishing, social engineering and fake websites, plus warning signs and safe practices. |
| **Knowledge Quiz** | 10 multiple-choice questions with automatic scoring and an answer review at the end. |

## How the analysis works

The analyzers are **rule-based (heuristic)**. They look for known warning signs and add points.

**Email checks:** urgent language, requests for passwords or OTPs, financial requests, "click here" style link wording, reward or threat language, unusual sender format, and a free email provider (Gmail, Yahoo, etc.) paired with an official-sounding subject.

**URL checks:** HTTP instead of HTTPS, punycode (`xn--`) domains, many nested subdomains, credentials inside the URL, very long hostnames, words like `login`, `verify` or `secure` in the hostname, many hyphens, and long query strings.

**Risk levels:** 0 to 34 is Low, 35 to 64 is Medium, 65 to 100 is High.

> **Important:** This is an educational tool, not a real security product. A low score does not prove an email or website is safe, and a high score does not prove it is malicious.

## Privacy

- No data is sent anywhere. All analysis happens in your browser.
- No URLs are opened and no external services are called.
- Scan history and the quiz score are stored in your browser's `localStorage` only. You can clear them from the Scan History page.
- Please do not paste real passwords or confidential messages into the analyzer.

## Tech stack

- HTML
- CSS (responsive layout, sidebar navigation)
- Vanilla JavaScript (no frameworks or libraries)

## How to run

1. Download or clone this repository.
2. Open `index.html` in any modern browser.

Optional: in VS Code, install the **Live Server** extension, right-click `index.html` and choose **Open with Live Server**.

## Project structure

```
CodeAlpha_PhishingAwareness/
├── index.html
└── README.md
```

## Task requirements covered

- Explains how to recognize phishing emails and fake websites (Email Analyzer, URL Analyzer, Awareness Guide)
- Educates about social engineering tactics (Awareness Guide)
- Provides best practices and tips (Awareness Guide)
- Includes an interactive quiz (Knowledge Quiz)

## What I learned

- How common phishing and social engineering tricks work
- How to break a URL into parts (protocol, hostname, query) using the JavaScript `URL` object
- How to build a rule-based scoring system
- How to store data in the browser with `localStorage`
- How to build a responsive dashboard layout

## Future improvements

- Add real-world phishing case studies
- Add more quiz questions and a timer
- Add more detection rules (lookalike domains such as `paypa1.com`)
- Add a light/dark theme switch

## Disclaimer

PhishGuard is built for learning and awareness only. Always verify suspicious messages through official channels.

---

Built by **Mahnoor Saghir** for the CodeAlpha Cyber Security Internship.

# SE333 - Assignment 5: UI Testing with Playwright

This project utilizes manual scripting with Playwright and AI-assisted test generation.

## GitHub Repository

[Link to your GitHub Repository](https://github.com/hammyo-o/playwrightjava25) 

## GitHub Actions CI Status

[![Java CI with Maven and Playwright](https://github.com/hammyo-o/playwrightjava25/actions/workflows/main.yml/badge.svg?branch=master)](https://github.com/hammyo-o/playwrightjava25/actions/workflows/main.yml)

---

## Reflection: Manual vs. AI-Assisted UI Testing

For this assignment, I had to make a UI test in two ways. By hand, and by telling an AI what to do. Both tests ended up working, but how I got there was totally different.
## Getting the Test Written

The AI was much faster, I just wrote a paragraph describing what I wanted, and it gave a working Java file in less than 2 minutes. Doing it myself was much slower because I had to manually click every button, text box, and CSS class and assertThat for the requirements.

## Which Test Was Better?

It was easier just to write and record the code myself to make sure it was checking the right thing. The manual test will be much easier to maintain. Since I wrote every line, I know exactly where to go if something breaks. If a button's ID changes, I can find it and fix it with the playwright recording. With the AI-generated code, I would first have to spend time figuring out what the AI decided to do and why. The AI follows the instructions in the prompt very literally and guesses on things incorrectly. I had to prompt it to use my exact css code and browser manipulation multiple times which was annoying and time consuming for no reason as it kept getting things wrong. 
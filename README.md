# Polynomial Secret Reconstruction

This project implements Secret Reconstruction using Lagrange Interpolation, inspired by Shamir’s Secret Sharing Scheme.

## 📖 Problem Overview

Given n shares of a polynomial of degree (k-1), the goal is to reconstruct the secret using at least k shares.

- The secret is stored as the constant term of the polynomial.
- Each share contains:
  - x value
  - y value (in different numerical bases)

The program:
1. Parses JSON input
2. Converts values from their respective bases to decimal
3. Uses Lagrange Interpolation
4. Computes the constant term f(0)

---

## 🧮 Mathematical Concept

If the polynomial degree is (k-1), then:
- Minimum k points are required for unique reconstruction.
- The secret = f(0)

Lagrange Formula:

f(0) = Σ yi * Li(0)

Where:

Li(0) = ∏ (0 - xj) / (xi - xj)

---

## ⚙️ Technologies Used

- Java
- org.json library
- Lagrange Interpolation
- Base Conversion

---

## 🚀 How to Run

Place the following files in the same folder:

- PolynomialSolver.java
- input.json
- json-20231013.jar

Compile:

javac -cp ".;json-20231013.jar" PolynomialSolver.java

Run:

java -cp ".;json-20231013.jar" PolynomialSolver

---

## 📌 Sample Output

Constant Term (c): <calculated value>

---

## 🔒 Security Insight

This approach demonstrates the principle of Shamir’s Secret Sharing:
- Any k shares can reconstruct the secret.
- Fewer than k shares reveal no information.

---

## 🔧 Possible Improvements

- Use BigInteger to handle very large values without overflow.
- Add input validation.
- Improve modular code structure.

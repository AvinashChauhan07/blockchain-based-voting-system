# 🗳️ Decentralized Voting System (DVS)

A **Decentralized Voting System** built using **Blockchain technology** to ensure transparency, security, and trust in the voting process.  
This project is developed as a **learning + academic project** using Ethereum smart contracts and Java (Spring Boot) backend.

---

## 📌 Project Overview

Traditional voting systems suffer from issues like:
- Lack of transparency  
- Centralized control  
- Data tampering risks  

This project addresses these issues by using **Blockchain (Ethereum)** where votes are recorded immutably on-chain.

---

## 🛠️ Tech Stack

### 🔹 Blockchain
- **Solidity** – Smart Contract
- **Remix IDE** – Contract development & deployment
- **Ganache** – Local Ethereum blockchain
- **MetaMask** – Wallet integration
- **Web3j** – Blockchain interaction (Java)

### 🔹 Backend
- **Java 17**
- **Spring Boot 2.7**
- **Spring Data JPA**
- **H2 Database** (In-memory)

### 🔹 Frontend
- **Thymeleaf**
- **HTML / CSS**

---

## ✨ Features

- 🧾 Candidate registration
- 🗳️ Secure voting using smart contracts
- 🔐 One vote per voter
- 📊 Transparent vote counting
- 🧪 Local blockchain testing (Ganache)

---

## 🚀 How to Run the Project (Local Setup)

### 1️⃣ Prerequisites
- Java **17**
- Maven
- Node.js
- Ganache
- MetaMask (Browser Extension)
- Remix IDE (Web)

---

### 2️⃣ Blockchain Setup
1. Start **Ganache**
2. Import Ganache account into **MetaMask**
3. Add Ganache network manually:
   - RPC URL: `http://127.0.0.1:7545`
   - Chain ID: `1337`
4. Open **Remix IDE**
5. Compile & deploy `Voting.sol` using **Injected Provider (MetaMask)**

---

### 3️⃣ Backend Setup
```bash
mvn clean install
mvn spring-boot:run

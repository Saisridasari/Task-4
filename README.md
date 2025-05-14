
# **User-Based Recommendation System in Java**

**Company**: CODETECH IT SOLUTIONS

**Name**: SAISRI DASARI

**Intern ID**: CT04DK210

**Domain**: JAVA DEVELOPER

**Duration**: 4 WEEKS

**Mentor**: NEELA SANTOSH

---

### 📌 **Project Description**

This Java project implements a **User-Based Collaborative Filtering Recommendation System** using the **Apache Mahout** library. The system analyzes user preferences from a dataset and provides personalized recommendations based on **similar users' ratings**.

The application demonstrates the following:

* **Reading user-item interaction data** from a CSV file
* **Calculating user similarity** using Pearson Correlation
* **Identifying neighborhoods** (similar users)
* **Generating top-N recommendations** for a target user

---

### 🛠️ **Technologies Used**

* Java (JDK 8 or higher)
* Apache Mahout (Recommender Framework)
* CSV File as the Data Source

---

### 📂 **Input Data Format (data.csv)**

The input file should be a CSV with the following format:

```
userID,itemID,rating
1,101,4.0
1,102,3.5
2,101,5.0
3,103,2.0
...
```

---

### 📥 **How It Works**

1. **Load Data**:
   Reads `data.csv` using `FileDataModel`.

2. **Similarity Calculation**:
   Computes similarity between users using **Pearson Correlation**.

3. **Neighborhood Formation**:
   Finds the top 3 most similar users (`NearestNUserNeighborhood`).

4. **Generate Recommendations**:
   Uses the `GenericUserBasedRecommender` to generate top 5 recommendations for user with ID `3`.

---

### 🧪 **Sample Output**

```bash
5
0.23961921
Recommendations for User 3:
Product ID: 104 | Estimated Rating: 4.52
Product ID: 102 | Estimated Rating: 3.87
Product ID: 101 | Estimated Rating: 3.64
...
```

If no recommendations are found:

```bash
No recommendations available for this user.
```


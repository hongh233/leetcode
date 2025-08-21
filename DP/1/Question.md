# Spare It Once

Tomori encounters `n` monsters in order, with their IDs ranging from 1 to `n`. Each monster `i (1 ≤ i ≤ n)` has a health value of `a_i`.

For each monster, Tomori can choose to either **skip it** or **defeat it**:

- If she **skips** the monster, she gains exactly `i` experience points.
- If she **defeats** the monster, she gains:
    - `a_i` base experience points,
    - plus an **additional bonus**: `(x mod 10) * a_i`, where `x` is the total number of monsters defeated so far **including this one**.

Her goal is to **maximize** the total experience gained from all `n` monsters.

---

## Time Limits

- C/C++: 1 second
- Other languages: 2 seconds

## Memory Limits

- C/C++: 256 MB
- Other languages: 512 MB

---

## Input

- The first line contains an integer `n (1 ≤ n ≤ 2×10^5)` — the number of monsters.
- The second line contains `n` integers `a_i (1 ≤ a_i ≤ 10^9)` — the health value of each monster.

---

## Output

- Output a single integer — the **maximum experience** Tomori can gain.

---

## Sample Input

```
3
5 3 2
```

## Sample Output
```
27
```
### Explanation

- Defeat the 1st monster: `5 + 1×5 = 10`
- Defeat the 2nd monster: `3 + 2×3 = 9`
- Defeat the 3rd monster: `2 + 3×2 = 8`
- Total experience: `10 + 9 + 8 = 27`
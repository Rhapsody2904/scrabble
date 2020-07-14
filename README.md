# scrabble
Simple optimized first hand play for Scrabble.

Heuristics.
As the quickest and simplest way to cut down on the search space, I chose to eliminate any words that were longer than 7 or shorter than 4 letters, because for a first play, one would hardly ever start out with a 4-letter word and the rack can only hold a maximum of 7 letters.
Additionally, in my recursive search function for permutations, I chose to include a check for a prefix’s existence in the dictionary—if the combination of the first few letters of the word doesn’t exist, there’s no point in checking the rest of the permutations for that sequence. This trimming significantly reduced the search space.
As a means to cut down on the amount of data my program had to process, I chose to pick the top 5-scoring words from my available list (the possibleWords list that holds all possible words from a given rack). The word costs are calculated during the creation of the dictionary and are stored in the last node of each word. During my time-trials, I noticed that it was not an optimal choice. Most of the time, the highest scoring words were the longest; however, occasionally, racks that had blanks ended up scoring higher values with shorter words, while the BINGO words never made it into my trimmed-down list (see trials 3 and 4, for rack LANK_I_). I attempted to remedy the problem by processing board placements for all available words from the possibleWords list, but that significantly reduced the program’s efficiency—so-much-so, that I had to cancel it mid-run. So, I chose to cut down on the words that were entered into the possibleWords list as I was processing them in the permutation. That still kept the efficiency and resolved my missing BINGO words issue—see trial 5. 
I still think my approach in designing this program was poor, as I should have created letter object that could have held individual values, because I had to do some band-aiding to try and figure out which letters were formerly the blanks. Most of the time, the agent will produce the highest scoring word, but there is no specific heuristics on the placement of blanks when they’re a letter that already originally existed in the rack; by default, the blank is always played as the first occurrence of the letter in the played word.

Strategies.
If I had had more time and the submission deadline was not creeping up so quickly, I would have included strategies for swapping/saving letters such as
•	Save a ‘U’ if ‘Q’ is in hand
•	Group and save ‘ING’ until it can be played as part of a BINGO
•	Match ‘ED’
However, with the limited time, I only kept three strategies:
•	Use blanks ONLY when a BINGO word can be played; otherwise, save
•	Maintain a balance between consonants and vowels—swap letters to keep a reasonable number of each. The latter is not perfect, as my agent doesn’t check what vowels it’s swapping (see trial 3, rack EEEIOII). Ideally, the agent would have a preference gradient that valued ‘E’s over ‘I’s. Similar distinctions would be implemented with consonants.
•	When swapping, save more valuable letters, such as ‘S.’ ‘X,’ ‘Q’

Performance.
For this assignment, I ended up researching a data structure that I had never worked with before (had not heard of it, in fact) – a Trie. While it is an extremely limited application data structure, when it comes for storing/accessing words, it is quite fantastic. Since every letter of the word is stored as a separate node, the depth of the graph is only as great as the longest word—in our case, 7. Its breadth is great, as each node has 26 children—one for each alphabet letter. Initially, I had started with a sorted arrayList for keeping track of my words, but finding a word in it would have been at a cost of about O(log n). The Trie structure allows the lookup of a word in as many steps as there are letters in the word—a fixed cost, so it’s fairly safe to say that the complexity of looking up a word is O(1). The Trie does take more memory than a tree or an array, but its efficiency far outweighs the cost.
While my dictionary and its access is great, the rest of my program leaves a lot to be desired. I employ many nested for loops and unnecessarily convoluted methods and statements. Many of those could be cleaned up and streamlined. For example, as in the Trial 3 and 4, the rack LANK_I_ had to go through many of these loops, its running time was significantly higher than the rest of the words—especially those that had no blanks and were looked up in the Trie (some taking only 1 or even 0 ms).

Trial Number	Rack	Winning Word	Running Time
1	DELIRYZ	DIRELY	13 ms
	EDFGON_	GONEF	26 ms
	ABC_DEF	FACED	7 ms
	QBMP_I_	---- (passed)	51 ms
	SSARLNE	RANSELS	1 ms
	ZUQI_DE	QUIZZED	3 ms
	FRIENDS	FINDERS	0 ms
Total Batch Running Time	244 ms
2	DELIRYZ	DIRELY	12 ms
	EDFGON_	GONEF	26 ms
	ABC_DEF	FACED	16 ms
	QBMP_I_	---- (passed)	49 ms
	SSARLNE	RANSELS	1 ms
	ZUQI_DE	QUIZZED	4 ms
	FRIENDS	FINDERS	1 ms
Total Batch Running Time	223 ms
3	QWERTY_	QWERTYS	53 ms
	EEEEIOII	---(swapped ‘EEE’)	 1 ms
	NAMERTU	TRUEMAN	2 ms
	LANK_I_	LAKIN	161 ms
	MISSION	MISSION	2 ms
	ZZE__SE	ZEZES	78 ms
	RIPOTFZ	FRITZ	1 ms
Total Batch Running Time	407 ms
4	QWERTY_	QWERTYS	38 ms
	EEEEIOII	---(swapped ‘EEE’)	1 ms
	NAMERTU	TRUEMAN	22 ms
	LANK_I_	LAKIN	155 ms
	MISSION	MISSION	0 ms
	ZZE__SE	ZEZES	89 ms
	RIPOTFZ	FRITZ	0 ms
Total Batch Running Time	405 ms
5	QWERTY_	QWERTYS 	41 ms
	EEEEIOII	---(swapped ‘EEE’)	0 ms
	NAMERTU	TRUEMAN	2 ms
	LANK_I_	MILKMAN	159 ms
	MISSION	Mission	1 ms
	ZZE__SE	TZETZES	74 ms
	RIPOTFZ	FRITZ	1 ms
Total Batch Running Time	414 ms


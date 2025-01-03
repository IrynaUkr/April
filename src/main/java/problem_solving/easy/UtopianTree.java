package problem_solving.easy;

import java.util.*;
import java.util.stream.Collectors;


public class UtopianTree {
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int start = a.get(a.size() - 1);
        int finish = b.get(0);
        List<Integer> res = new ArrayList<>();

        for (int i = start; i <= finish; i++) {
            boolean isFactor = true;
            int index = 0;
            while (isFactor && index < a.size()) {
                isFactor = i % a.get(index) == 0;
                index++;
            }
            if (isFactor) {
                res.add(i);
            }
        }
        int counter = 0;
        for (Integer fac : res) {
            int index = 0;
            boolean isEven = true;
            while (isEven && index < b.size()) {
                isEven = b.get(index) % fac == 0;
                index++;
            }
            if (isEven) {
                counter++;
            }
        }
        return counter;
    }


    public static int birthday(List<Integer> s, int d, int m) {
        int counter = 0;
        for (int i = 0; i < s.size(); i++) {
            int index = i;
            int length = 0;
            int sum = 0;

            while (length <= m && sum <= d && index < s.size()) {
                sum += s.get(index);
                length++;
                if (length == m && sum == d) {
                    counter++;
                }
                index++;

            }
        }
        return counter;

    }

    public static int migratoryBirds(List<Integer> arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (Integer typeId : arr) {
            if (freqMap.containsKey(typeId)) {
                freqMap.put(typeId, freqMap.get(typeId) + 1);
            } else {
                freqMap.put(typeId, 1);
            }
        }
        int maxOccurance = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxOccurance) {
                maxOccurance = entry.getValue();
            }
        }
        // freqMap.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get();
        List<Integer> maxTypes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxOccurance) {
                maxTypes.add(entry.getKey());
            }
        }
        return maxTypes.stream().min(Comparator.comparingInt(Integer::intValue)).get();
    }


    public static String encryption(String s) {
        String stripped = s.replace(" ", "");
        int rows = (int) Math.sqrt(stripped.length());
        int columns = (int) Math.ceil(Math.sqrt(stripped.length()));
        //split by rows
        List<String> strings = new ArrayList<>();
        int tail = stripped.length() % columns;
        for (int i = 0; i <= stripped.length() - tail; i += columns) {
            if (i + columns > stripped.length()) {
                strings.add(stripped.substring(i));
            } else {
                strings.add(stripped.substring(i, i + columns));
            }
        }
        //extract each character
        StringBuilder encodedString = new StringBuilder();
        for (int i = 0; i < columns; i++) {
            StringBuilder word = new StringBuilder();
            for (String string : strings) {
                if (string.length() > i) {
                    word.append(string.charAt(i));
                }
            }
            word.append(" ");
            encodedString.append(word);
        }
        return encodedString.toString();
    }


    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList();
        // Remove duplicates from ranked and sort in descending order
        List<Integer> distinctRanked = ranked.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        ;

        List<Integer> results = new ArrayList<>();
        int index = distinctRanked.size() - 1;

        // Iterate through player scores
        for (int score : player) {
            // Move the index down while the player's score is greater than ranked[index]
            while (index >= 0 && score >= distinctRanked.get(index)) {
                index--;
            }
            // Add rank (index + 2 because index is 0-based and we move one step beyond)
            results.add(index + 2);
        }
        return results;

    }

    public static List<Integer> climbingLeaderboard2(List<Integer> ranked, List<Integer> player) {
        ArrayList<Integer> changedList = new ArrayList<>(ranked);
        ArrayList<Integer> ranks = new ArrayList<>();
        for (Integer score : player) {
            if (!changedList.contains(score)) {
                addElement(score, changedList);
                ranks.add(getRank(score, changedList));
            } else {
                int rank = getRank(score, changedList);
                ranks.add(rank);
            }
        }
        return ranks;
    }

    private static int getRank(Integer score, ArrayList<Integer> changedList) {
        int rank = 1;
        for (int i = 0; i < changedList.size(); i++) {
            if (Objects.equals(score, changedList.get(i))) {
                return rank;
            }
            Integer current = changedList.get(i);
            Integer next = changedList.get(i + 1);
            if (i < changedList.size() - 1 && !Objects.equals(current, next)) {
                rank++;
            }
        }
        return rank;
    }

    private static void addElement(Integer score, ArrayList<Integer> changedList) {
        if (score > changedList.get(0)) {
            changedList.add(0, score);
        } else if (score < changedList.get(changedList.size() - 1)) {
            changedList.add(score);
        } else {
            for (int i = 0; i < changedList.size() - 1; i++) {
                if (score < changedList.get(i) && score > changedList.get(i + 1)) {
                    changedList.add(i + 1, score);
                }
            }
        }
    }

    private static List<Integer> getIntegers(String input) {
        String[] rankedArr = input.split(" ");
        List<Integer> inputRanked = Arrays.asList(rankedArr)
                .stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return inputRanked;
    }

    public static int pageCount(int n, int p) {
        boolean isEnd = p > n / 2;
        if (isEnd) {
            if (n % 2 == 0) {
                n++;
            }
            return (n - p) / 2;
        } else {
            return p / 2;
        }
    }

    public static int pickingNumbers(List<Integer> a) {
        int max = 0;
        int counter = 0;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (Integer num : a) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int currentVal = frequencyMap.get(key);
            int adjestedVal = frequencyMap.getOrDefault(key + 1, 0);
            max = Math.max(max, currentVal + adjestedVal);
        }

        return max;
    }

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        List<Integer> rotated = new ArrayList<>();

        int n = a.size();
        int rotateSteps = k % n; // Effective rotations

        // Step 1: Find the split point
        int splitPoint = n - rotateSteps;

            for (int i = splitPoint; i < a.size(); i++) {
                rotated.add(a.get(i));
            }
            for (int i = 0; i < splitPoint; i++) {
                rotated.add(a.get(i));
            }

        List<Integer> result = new ArrayList<>();
        for (Integer query : queries) {
            result.add(rotated.get(query));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 4, 5,0,0,0,0,0,0);
        List<Integer> i = Arrays.asList(1,2);

        String inputS ="10160 27429 61174 92314 90626 66576 13013 3055 28071 13366 48292 83192 376 63276 35825 39497 39701 46967 95656 92257 31122 91431 72587 78900 77935 27666 52875 56477 89913 43214 32042 16424 70643 9567 25090 61268 76142 38102 80674 4212 67819 45317 3756 68194 8592 39580 24042 64644 2898 36050 73252 34020 27480 62191 12919 5415 6208 82146 78243 12472 25359 10284 28896 12353 36202 53985 89973 12343 8438 86998 32907 76257 32315 36662 60802 57258 92593 84844 38254 95490 37245 11505 45861 81076 73695 58780 86490 96254 57277 81085 8726 98987 7720 53973 11340 43922 24309 17664 56264 32746 4661 89170 25354 53327 42183 86156 10585 34775 87351 48838 30265 24595 76694 76125 5670 66741 51256 8512 62994 8532 5948 88071 23871 13667 42043 51562 73940 66351 69225 46556 15449 73885 35725 40802 43564 94260 43309 54148 29034 30659 19337 59298 71605 96030 51775 93627 79122 3030 18490 42116 27914 40789 30186 51784 54455 88581 3345 44747 54931 88921 91302 86731 79157 43378 43885 22720 37637 87193 93219 66671 17852 12555 42320 5808 24937 94094 15786 4058 13476 34275 62525 57741 75063 9063 9524 45870 97643 29220 6968 68925 34492 98269 55656 13648 57998 99540 52720 95635 86732 45938 78657 20935 74845 37328 43095 99781 47774 58880 20190 61249 9507 99067 35341 84569";
        List<Integer> inp = extractListFromString(inputS);
        String q = "76 39 57 212 202 210 14 47 188 183 178 78 148 19 118 74 103 52 72 97 155 52 75 48 202 202 14 112 210 34 104 4 5 94 148 207 90 163 186 211 132 83 75 67 102 193 73 205 177 77 88 50 62 163 99 50 84 113 162 12 148 198 17 153 78 165 79 101 46 197 98 179 66 105 178 101 16 183 92 193 46";
        List<Integer> query = extractListFromString(q);
        circularArrayRotation(input, 6, i);
    }

    private static List<Integer> extractListFromString(String arr) {
        String[] s = arr.split(" ");
        return Arrays.asList(s).stream().map(x -> Integer.valueOf(x)).toList();
    }

}




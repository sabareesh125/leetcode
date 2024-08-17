class Solution {
    public List<List<String>> groupAnagrams(String[] s) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String i : s){
            char c[] = i.toCharArray();
            Arrays.sort(c);
            String temp = new String(c);
            if(!map.containsKey(temp))
                map.put(temp,new LinkedList<String>());
            map.get(temp).add(i);
        }

        return new LinkedList<>(map.values());
    }
}
class Solution {
    double k ;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,HashMap<String,Double>> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        int len = equations.size();
        List<String> temp;
        for(int i = 0 ;i<len;i++){
            temp = equations.get(i);
            set.add(temp.get(0));
            set.add(temp.get(1));
            if(!map.containsKey(temp.get(0))){
                map.put(temp.get(0),new HashMap<>());
            }
            if(!map.containsKey(temp.get(1))){
                map.put(temp.get(1),new HashMap<>());
            }
            map.get(temp.get(0)).put(temp.get(1), values[i]);
            map.get(temp.get(1)).put(temp.get(0), 1/values[i]);
        }
        len = queries.size();
        double ans[]=new double[len];
        for(int i=0;i<len;i++){
            temp = queries.get(i);
            if(!set.contains(temp.get(0))||!set.contains(temp.get(1))){
                ans[i]=-1.0;
                continue;
            }
            k = -1.0;
            find(map,temp.get(0),temp.get(1),new HashSet<>(),1);
            ans[i]=k;
        }
        return ans;
    }
    void find(HashMap<String,HashMap<String,Double>> map,String source,String target,HashSet<String> set,double currentValue){
        if(target.equals(source)){
            k = currentValue;
            return;
        }
        set.add(source);
        HashMap<String,Double> current = map.get(source);
        for(Map.Entry<String,Double> e:current.entrySet()){
            if(set.contains(e.getKey())){
                continue;
            }
            find(map,e.getKey(),target,set,currentValue*e.getValue());
            if(k!=-1){
                return;
            }
        }
    }
}
class Solution {
    public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> mainList = new ArrayList<>();
    List<Integer> fRow = new ArrayList<>();
    List<Integer> sRow = new ArrayList<>();
    fRow.add(1);sRow.add(1);sRow.add(1);
    mainList.add(fRow);
    if(numRows==1)
    return mainList;
    mainList.add(sRow);
    if(numRows==2)
    return mainList;
   

    for(int i=0; i<numRows-2;i++)
    {
        List<Integer> nRow = new ArrayList<>();
        nRow=createOneRow(mainList.get(mainList.size()-1));
        mainList.add(nRow);
    }

      return mainList;  
    }
    List<Integer> createOneRow(List<Integer> arr)
    {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int ptr1=0;
        int ptr2=1;
        while(ptr2<arr.size())
        {
            int ele=arr.get(ptr1)+arr.get(ptr2);
            list.add(ele);
            ptr1++;
            ptr2++;
        }
        list.add(1);

        return list;
    }
}
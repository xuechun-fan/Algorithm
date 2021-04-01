import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


class 字符串四种格式转换{
    public String getString(String s){
        if(s==null || s.length()==0){
            return "";
        }
        char[] arr = s.toCharArray();
        List<String> ans = null;
        //    判断输入的形式
        if(arr[0]<='Z' && arr[0]>='A'){
            //    转调第一种输入的处理函数
            ans = case1And2(s);
        }else{
            //    第一个字母小写，但是还不能确定剩下三种的哪一种
            int i = 0;
            boolean two = false;
            List<Integer> modify = new ArrayList<>();
            while(i<arr.length){
                if(arr[i]<='Z' && arr[i]>='A'){
                    two = true;
                    break;
                }
                if(arr[i]=='_' || arr[i]=='-'){
                    modify.add(i);
                }
                i++;
            }
            if(two){
                //    修改第一字符为大写，转调case1方法
                arr[0] = (char)(arr[0]-32);
                ans = case1And2(new String(arr));
            }else{
                //    输入为case3 或者 case4
                ans = case3And4(arr, modify);
            }
        }
        StringBuilder tmp = new StringBuilder();
        for(String str : ans){
            tmp.append(str);
            tmp.append(" ");
        }
        return tmp.toString().trim();
    }

    private List<String> case1And2(String s){
        //    当前输入为首字母大写方式
        //    先将第一种形式加入结果集
        List<String> ans = new ArrayList<String>();
        StringBuilder tmp = new StringBuilder();
        char[] arr = s.toCharArray();
        ans.add(s);
        //    再处理驼峰形式
        arr[0] = (char)(arr[0]+32);
        ans.add(new String(arr));
        //    再将处理操作还原-->为了下面方便处理，这里就不再还原字符
        //    arr[0] = (char)(arr[0]-'A'-32);
        //    然后处理剩下两种形式
        List<Integer> upperIndex = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i]<='Z' && arr[i]>='A'){
                //    将大写字符全部转成小写
                arr[i] = (char)(arr[i]+32);
                //    并记录位置
                upperIndex.add(i);
            }
        }
        //    记录完大写字母的位置后开始添加到结果集，目前记录下来的位置都是需要处理的位置
        tmp.append(new String(arr));
        int det = 0;
        for(Integer index : upperIndex){
            tmp.insert(index+(det++), String.valueOf('_'));
        }
        //    添加第三种结果
        ans.add(tmp.toString());

        //    添加第四种结果
        ans.add(tmp.toString().replace('_', '-'));
        return ans;
    }

//    PascalCaseTest pascalCaseTest pascal_case_test pascal-case-test
    private List<String> case3And4(char[] arr, List<Integer> modify){
        List<String> ans = new ArrayList<String>();
        StringBuilder tmp = new StringBuilder();
        //    先判断3、4哪一种
        boolean three = arr[modify.get(0)]=='_';
        if(three){
            //    直接添加当前结果，即第三种
            ans.add(new String(arr));
            //    处理成第四种
            ans.add(new String(arr).replace('_', '-'));
        }else{
            //    直接添加当前结果，即第4种
            ans.add(new String(arr));
            //    处理成第3种
            ans.add(0, new String(arr).replace('-', '_'));
        }
        //    然后处理成前两种结果
        //    先考虑第二种形式，把该转换的字符转换成大写
        for(Integer i : modify){
            arr[i+1] = (char)(arr[i+1] - 32);
        }
        int start = 0;
        for(int i=0; i<modify.size(); i++){
            int end = modify.get(i);
            tmp.append(new String(arr, start, end-start));
            start = end + 1;
        }
        tmp.append(arr, start, arr.length-start);
        //    这个时候已经处理成tmp已经是第二种形式
        ans.add(0,tmp.toString());
        //    修改第一个字符为大写
        tmp.setCharAt(0, (char)(arr[0] - 32));
        ans.add(0,tmp.toString());
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        String string = new 字符串四种格式转换().getString(str);
        System.out.println(string);

    }

}

public class WorkOut {
    public static void main(String[] args) {
        String text ="Showing 1 to 10 of 0 ( Pages)";
        int start=text.indexOf('(');
        int end=text.indexOf(" Pages");
        String sub=text.substring(start+1,end);
        System.out.println(sub);
    }
}

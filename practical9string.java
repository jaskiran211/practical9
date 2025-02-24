public class Practical9string{
public static void main(String[] args){
if(args.length!=3){
System.out.println("Please enter size, start range and end range");
return;
}
int size=Integer.parseInt(args[0]);
int startRange=Integer.parseInt(args[1]);
int endRange=Integer.parseInt(args[2]);
String[] strings=new String[size];
for(int i=0;i<size;i++){
long nanoTime=System.nanoTime();
int num=startRange+(int)(nanoTime%(endRange-startRange+1));
strings[i]=generateRandomString(num);
}
for(int i=0;i<strings.length;i++){
System.out.println("String: "+strings[i]);
}
double avgTimeString=calculateAverageTimeString(strings);
System.out.println("Average time for String concatenation: "+avgTimeString);
double avgTimeStringBuilder=calculateAverageTimeStringBuilder(strings);
System.out.println("Average time for StringBuilder concatenation: "+avgTimeStringBuilder);
double avgTimeStringBuffer=calculateAverageTimeStringBuffer(strings);
System.out.println("Average time for StringBuffer concatenation: "+avgTimeStringBuffer);
}
public static String generateRandomString(int length){
String characters="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
StringBuilder sb=new StringBuilder();
for(int i=0;i<length;i++){
int index=(int)(System.nanoTime()%characters.length());
sb.append(characters.charAt(index));
}
return sb.toString();
}
public static double calculateAverageTimeString(String[] strings){
long totalTime=0;
for(String str:strings){
long startTime=System.nanoTime();
String result="";
for(int i=0;i<1000;i++){
result+=str;
}
long endTime=System.nanoTime();
totalTime+=(endTime-startTime);
}
return totalTime/(double)strings.length;
}
public static double calculateAverageTimeStringBuilder(String[] strings){
long totalTime=0;
for(String str:strings){
long startTime=System.nanoTime();
StringBuilder sb=new StringBuilder();
for(int i=0;i<1000;i++){
sb.append(str);
}
long endTime=System.nanoTime();
totalTime+=(endTime-startTime);
}
return totalTime/(double)strings.length;
}
public static double calculateAverageTimeStringBuffer(String[] strings){
long totalTime=0;
for(String str:strings){
long startTime=System.nanoTime();
StringBuffer sb=new StringBuffer();
for(int i=0;i<1000;i++){
sb.append(str);
}
long endTime=System.nanoTime();
totalTime+=(endTime-startTime);
}
return totalTime/(double)strings.length;
}
}
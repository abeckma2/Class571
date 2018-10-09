import java.io.*;
import java.util.*;
/**
 * Allan Beckman
 * E01238245
 * assignment 0927
 * https://github.com/abeckma2/Class571
 * records in random access files
 */
public class Project2
{
   public static void main(String[] args)
   {
       try
       {
           RandomAccessFile ioStream = new RandomAccessFile("records","rw");
           ioStream.writeInt(1);
           ioStream.writeDouble(1.0);
           ioStream.writeChar('a');
           ioStream.writeInt(2);
           ioStream.writeDouble(2.0);
           ioStream.writeChar('b');
           ioStream.writeInt(3);
           ioStream.writeDouble(3.0);
           ioStream.writeChar('c');
           ioStream.writeInt(4);
           ioStream.writeDouble(4.0);
           ioStream.writeChar('d');
           ioStream.writeInt(5);
           ioStream.writeDouble(5.0);
           ioStream.writeChar('e');
           ioStream.writeInt(6);
           ioStream.writeDouble(6.0);
           ioStream.writeChar('f');
           
           System.out.println("What do you wish to do?");
           System.out.println("Press '1' to see list of double");
           System.out.println("press '2' to locate int value 4 and print out record");
           System.out.println("press '3' to choosethe option where you choose a number, and all records below that number gets printed");
           System.out.println("press 'close' to close the program");
           Scanner keyboard=new Scanner(System.in);
           String input=keyboard.next();
           while(0!=input.compareToIgnoreCase("close"))
           {
               if(0==input.compareTo("1"))
               {
                   long length=ioStream.length();
                   long i=4;
                   while(i<length)
                   {
                       ioStream.seek(i);
                       double output=ioStream.readDouble();
                       System.out.println(output);
                       i=i+(4+8+2);
                   }
               }
               if(0==input.compareTo("2"))
               {
                   long length=ioStream.length();
                   long i=0;
                   while(i<length)
                   {
                       ioStream.seek(i);
                       int output = ioStream.readInt();
                       if(output==4)
                       {
                           ioStream.seek(i+4);
                           double output1=ioStream.readDouble();
                           ioStream.seek(i+12);
                           char output2=ioStream.readChar();
                           System.out.println(output+" "+output1+" "+output2);
                           break;
                       }
                       i=i+(4+8+2);
                   }
               }
               if(0==input.compareTo("3"))
               {
                   System.out.println("choose in arabic numerals a number between 2 and 5");
                   int inputInt=keyboard.nextInt();
                   while(!((2<=inputInt)&&(inputInt<=5)))
                   {
                       System.out.println("try again");
                       inputInt=keyboard.nextInt();
                   }
                   long length=ioStream.length();
                   long i=0;
                   while(i<length)
                   {
                       ioStream.seek(i);
                       int output = ioStream.readInt();
                       ioStream.seek(i+12);
                       char output1=ioStream.readChar();
                       System.out.println(output1);
                       if(output==inputInt)
                       {
                           break;
                       }
                       i=i+(4+8+2);
                   }
               }
               System.out.println("try again");
               input=keyboard.next();
           }
           ioStream.close();
       }
       catch(FileNotFoundException e)
       {
           System.out.println("file not found");
       }
       catch(IOException e)
       {
           System.out.println("end of program");
       }
   }
}

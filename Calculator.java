/*20174340209徐益平 
没有栈对优先级的操作，直接调用一个函数对字符串求值,也有优先级，
可以增加键盘事件，这样对！,x^2可以直接按Enter键得到结果*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;                                                                    //按钮
import javax.swing.JFrame;                                                                     //窗口
import javax.swing.JPanel;                                                                      //文本域
import javax.swing.JTextField;                                                                //文本框
import javax.swing.JTextArea;                                                                //可调大小的文本框
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
//import java.unit.Stack;                                                                         //栈道  

public class Calculator extends JFrame implements ActionListener      //继承监听事件接口    
{
   private JFrame f;                                                                                 //窗口
   private JTextField inputField;                                                             //文本框
   private String[] name={"C","/","*","Backpace","1/x","x^2","+/-","-","7","8","9","+","4","5","6","1","2","3","=","%","0","."};
   private  JButton btn[]=new JButton[name.length];                          //按键
   private  JPanel panel;
   private  boolean firstdigit=true;                                                        //是否为第一个键盘输入值
   private  double resultNum=0.0;                                                        //操作数
   private  String oprator="=";                                                              //操作符
   static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");  //JDK自带的类可以实现调用JS的功能，可以实现执行字符串中的运算公式的功能
  
   public Calculator()
    {  
          //窗体
          f=new JFrame(" Calculator");                                                       //构建一个叫Caculator的窗体
         // f.setLayout(new GridLayout(4,4));                                            //窗体为4*4的网格，现在使用自定义控件位置
          f.setSize(430,660);                                                                       //窗体大小

        //输入文本框
         inputField=new JTextField("0");
         inputField.setBounds(5, 8, 390, 50);                                             //控件左上角在容器中的坐标，控件的宽度，高度
         inputField.setHorizontalAlignment(JTextField.RIGHT);               //字体在文本框中的位置
        //inputField.setSize(100,20);
         f.add(inputField,BorderLayout.NORTH);
         f.add(inputField);                                                                          //把文本框加入面板中
   
          //按键
          f.setLocation(390,250);//窗体显示的位置
          for(int i=0;i<btn.length;i++) 
         {
             btn[i]=new JButton(name[i]);
             btn[i].addActionListener(this);//为按钮添加监听器
            // btn[i].ActionCommand(btn[i].getName());
             f.add(btn[i]);
          }

         //设置控件的位置
         btn[0].setBounds(5,70,95,90);                                                     //计算器宽为95，高为90
         btn[1].setBounds(100,70,95,90);
         btn[2].setBounds(195,70,95,90);
         btn[3].setBounds(290,70,95,90);
         btn[4].setBounds(5,160,95,90);
         btn[5].setBounds(100,160,95,90);
         btn[6].setBounds(195,160,95,90);
         btn[7].setBounds(290,160,95,90);
         btn[8].setBounds(5,250,95,90);
         btn[9].setBounds(100,250,95,90);
         btn[10].setBounds(195,250,95,90);
         btn[11].setBounds(290,250,95,90);
         btn[12].setBounds(5,330,95,90);
         btn[13].setBounds(100,330,95,90);
         btn[14].setBounds(195,330,95,90);
         btn[15].setBounds(5,420,95,90);
         btn[16].setBounds(100,420,95,90);
         btn[17].setBounds(195,420,95,90);
         btn[18].setBounds(290,330,95,270);
         btn[19].setBounds(5,510,95,90);
         btn[20].setBounds(100,510,95,90);
         btn[21].setBounds(195,510,95,90);
       
       
         //为控件设置颜色
        for(int i=0;i<7;i++)
            {
	btn[i].setBackground(Color.gray);
	btn[i].setForeground(Color.WHITE);
            }
       btn[7].setBackground(Color.gray);
       btn[7].setForeground(Color.WHITE);
       btn[11].setBackground(Color.gray);
       btn[11].setForeground(Color.WHITE);
       btn[18].setBackground(Color.red);
       btn[18].setForeground(Color.black);

       //将按钮放入界面中
         panel=new JPanel();
         //panel1=new JPanel();
         //panel.setLayout(new GridLayout(4,4));
       /* for(int i=0;i<btn.length;i++)
         {
          panel.add(btn[i]);                                                                           //所以panel呢？
         }*/
         f.add(panel,BorderLayout.CENTER);

        
         f.setVisible(true);//显示界面
         //为窗口组件设置监听器
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

public void actionPerformed(ActionEvent e) 
{
          String label=e.getActionCommand();                                         //获取该按键内容
         
           //handleEquation(label);
          switch(label)
         {
            case "C": handleC();break;                                                                                        //清零按键
            case "Backpace":inputField.setText(handleBackpace());break;                                //退格键
            case "=":handleResult();break;                                                                                 //处理算式，得到结果
            case "1/x":handleRec(); break;                                                                                 //求倒数
            case  "x^2":handleSqu();break;                                                                               //求平方
            case  "+/-":handleOPP();break;                                                                                    //阶乘
            default : handleEquation(label);break;                                                                    //处理数字符号
      }                           
}

//清零按键
public void handleC()                                                                          
    {
                                      inputField.setText("0"); 
                                   //firstdigit=true;
                                 // oprator="=";
    }

    //退格键
   public String handleBackpace()
   {
                                              String text=inputField.getText();
                                              int i=text.length();
                                             //字长大于0，退格，删除字符串的最后一个字符
                                             if(i==1)
                                                    {
                                                                /*firstdigit=true;
                                                                   oprator="=";*/
                                                                   return "0";
                                                   }//没有字符，置0
                                           else
                                                 {
                                                                   text=text.substring(0,i-1);
                                                                   return text;
                                                 }//否则将新的字符串显示
 }


//输出显示操作
public void handleEquation(String label)
		{
			if(inputField.getText().equals("0"))
			{
				inputField.setText(label);
			}
			else
			{
				inputField.setText(inputField.getText()+label);
			}

	              }



//得到最后一位数字的下标
public int GetLastDig()
{
                             String label=inputField.getText();
                              StringBuffer str=new StringBuffer();
                              int i; 
                              for( i=label.length()-1;i>=0;i--)
                              {
                                                  char c=label.charAt(i);
                                                   if(!Character.isDigit(c)&&c!='.')
                                                             break;//截取最后一个数字
                                                  //str.append(c);
                                               }
                            //str.reverse();//倒置
                            return i;


}


    
  //求倒数            
public void handleRec()
{                        
                           String label=inputField.getText();
                           int i=GetLastDig();                                                             //得到最后一个数字的下标
                           //得到除最后一位数字外的算式
                           StringBuffer s=new StringBuffer(label);
                           s= s.insert(i+1,"1/");                                                          //在原算式中插入"1/”
                           inputField.setText(s.toString());                                              
}

//求平方
public void handleSqu()
{
                                             //先得到最后一位数字
                                             String label=inputField.getText();
                                             StringBuffer str=new StringBuffer();
                                             int n=GetLastDig();                                           //得到最后一个数字的下标
                                             for(int  i=n+1;i<label.length();i++)
                                              {
                                                  char c=label.charAt(i);
                                                   str.append(c);
                                              }
                                            label=label+"*"+str.toString();
                                          inputField.setText(label);                                                                                           
}

    //求算式的相反数
  public void handleOPP()
    {
                                          String label=inputField.getText();
                                          label="-"+"("+label+")";
                                          inputField.setText(label);        
    }

   //求阶乘,只能是整数
 /* public void handleFac()
         {
                                             //先得到最后一位数字
                                            /* int data;//最后一位数字，需要是整数
                                             String label=inputField.getText();
                                             StringBuffer str=new StringBuffer();
                                             int n=GetLastDig();//得到最后一个数字的下标
                                             for(int  i=n+1;i<label.length();i++)
                                              {
                                                  char c=label.charAt(i);
                                                  str.append(c);
                                              }	 String s=str.toString();
                                                 data=Integer.toString(s);
                                                label=label.subtring(0,n+1);//截取除啦最后一位数字以外的算式
                                              String text=Integer.toString(Fn(data));
                                              text+=label;
                                              inputField.setText(text);       
                                                                                              
         }

//递归求阶乘
public int Fn(int n)
       {
        if(n==1)
           return 1;
         return n*Fn(n-1);
    }
*/





//处理结果
public void handleResult()
		{
			String text=inputField.getText();
			try 
			{
				Object a=jse.eval(text);          //jse.eval()直接计算字符串算式
				text=String.valueOf(a);         //将数字转换成字符串
				inputField.setText(text);
			} 
			catch (ScriptException e) 
			{
				e.printStackTrace();
				inputField.setText("算式格式不正确!");
			}
		}


public static void main (String [] args)
   {
                                   Calculator c=new Calculator();
   
    }



//处理数字
/*public void handleNum(String label)
             {
            if(firstdigit)
                 {
                   inputField.setText(label);
                 }
              else if(label.equals(".")&&(inputField.getText().indexof(".")<0)//
          }*/

}



                   

/*20174340209����ƽ 
û��ջ�����ȼ��Ĳ�����ֱ�ӵ���һ���������ַ�����ֵ,Ҳ�����ȼ���
�������Ӽ����¼��������ԣ�,x^2����ֱ�Ӱ�Enter���õ����*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;                                                                    //��ť
import javax.swing.JFrame;                                                                     //����
import javax.swing.JPanel;                                                                      //�ı���
import javax.swing.JTextField;                                                                //�ı���
import javax.swing.JTextArea;                                                                //�ɵ���С���ı���
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
//import java.unit.Stack;                                                                         //ջ��  

public class Calculator extends JFrame implements ActionListener      //�̳м����¼��ӿ�    
{
   private JFrame f;                                                                                 //����
   private JTextField inputField;                                                             //�ı���
   private String[] name={"C","/","*","Backpace","1/x","x^2","+/-","-","7","8","9","+","4","5","6","1","2","3","=","%","0","."};
   private  JButton btn[]=new JButton[name.length];                          //����
   private  JPanel panel;
   private  boolean firstdigit=true;                                                        //�Ƿ�Ϊ��һ����������ֵ
   private  double resultNum=0.0;                                                        //������
   private  String oprator="=";                                                              //������
   static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");  //JDK�Դ��������ʵ�ֵ���JS�Ĺ��ܣ�����ʵ��ִ���ַ����е����㹫ʽ�Ĺ���
  
   public Calculator()
    {  
          //����
          f=new JFrame(" Calculator");                                                       //����һ����Caculator�Ĵ���
         // f.setLayout(new GridLayout(4,4));                                            //����Ϊ4*4����������ʹ���Զ���ؼ�λ��
          f.setSize(430,660);                                                                       //�����С

        //�����ı���
         inputField=new JTextField("0");
         inputField.setBounds(5, 8, 390, 50);                                             //�ؼ����Ͻ��������е����꣬�ؼ��Ŀ�ȣ��߶�
         inputField.setHorizontalAlignment(JTextField.RIGHT);               //�������ı����е�λ��
        //inputField.setSize(100,20);
         f.add(inputField,BorderLayout.NORTH);
         f.add(inputField);                                                                          //���ı�����������
   
          //����
          f.setLocation(390,250);//������ʾ��λ��
          for(int i=0;i<btn.length;i++) 
         {
             btn[i]=new JButton(name[i]);
             btn[i].addActionListener(this);//Ϊ��ť��Ӽ�����
            // btn[i].ActionCommand(btn[i].getName());
             f.add(btn[i]);
          }

         //���ÿؼ���λ��
         btn[0].setBounds(5,70,95,90);                                                     //��������Ϊ95����Ϊ90
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
       
       
         //Ϊ�ؼ�������ɫ
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

       //����ť���������
         panel=new JPanel();
         //panel1=new JPanel();
         //panel.setLayout(new GridLayout(4,4));
       /* for(int i=0;i<btn.length;i++)
         {
          panel.add(btn[i]);                                                                           //����panel�أ�
         }*/
         f.add(panel,BorderLayout.CENTER);

        
         f.setVisible(true);//��ʾ����
         //Ϊ����������ü�����
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

public void actionPerformed(ActionEvent e) 
{
          String label=e.getActionCommand();                                         //��ȡ�ð�������
         
           //handleEquation(label);
          switch(label)
         {
            case "C": handleC();break;                                                                                        //���㰴��
            case "Backpace":inputField.setText(handleBackpace());break;                                //�˸��
            case "=":handleResult();break;                                                                                 //������ʽ���õ����
            case "1/x":handleRec(); break;                                                                                 //����
            case  "x^2":handleSqu();break;                                                                               //��ƽ��
            case  "+/-":handleOPP();break;                                                                                    //�׳�
            default : handleEquation(label);break;                                                                    //�������ַ���
      }                           
}

//���㰴��
public void handleC()                                                                          
    {
                                      inputField.setText("0"); 
                                   //firstdigit=true;
                                 // oprator="=";
    }

    //�˸��
   public String handleBackpace()
   {
                                              String text=inputField.getText();
                                              int i=text.length();
                                             //�ֳ�����0���˸�ɾ���ַ��������һ���ַ�
                                             if(i==1)
                                                    {
                                                                /*firstdigit=true;
                                                                   oprator="=";*/
                                                                   return "0";
                                                   }//û���ַ�����0
                                           else
                                                 {
                                                                   text=text.substring(0,i-1);
                                                                   return text;
                                                 }//�����µ��ַ�����ʾ
 }


//�����ʾ����
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



//�õ����һλ���ֵ��±�
public int GetLastDig()
{
                             String label=inputField.getText();
                              StringBuffer str=new StringBuffer();
                              int i; 
                              for( i=label.length()-1;i>=0;i--)
                              {
                                                  char c=label.charAt(i);
                                                   if(!Character.isDigit(c)&&c!='.')
                                                             break;//��ȡ���һ������
                                                  //str.append(c);
                                               }
                            //str.reverse();//����
                            return i;


}


    
  //����            
public void handleRec()
{                        
                           String label=inputField.getText();
                           int i=GetLastDig();                                                             //�õ����һ�����ֵ��±�
                           //�õ������һλ���������ʽ
                           StringBuffer s=new StringBuffer(label);
                           s= s.insert(i+1,"1/");                                                          //��ԭ��ʽ�в���"1/��
                           inputField.setText(s.toString());                                              
}

//��ƽ��
public void handleSqu()
{
                                             //�ȵõ����һλ����
                                             String label=inputField.getText();
                                             StringBuffer str=new StringBuffer();
                                             int n=GetLastDig();                                           //�õ����һ�����ֵ��±�
                                             for(int  i=n+1;i<label.length();i++)
                                              {
                                                  char c=label.charAt(i);
                                                   str.append(c);
                                              }
                                            label=label+"*"+str.toString();
                                          inputField.setText(label);                                                                                           
}

    //����ʽ���෴��
  public void handleOPP()
    {
                                          String label=inputField.getText();
                                          label="-"+"("+label+")";
                                          inputField.setText(label);        
    }

   //��׳�,ֻ��������
 /* public void handleFac()
         {
                                             //�ȵõ����һλ����
                                            /* int data;//���һλ���֣���Ҫ������
                                             String label=inputField.getText();
                                             StringBuffer str=new StringBuffer();
                                             int n=GetLastDig();//�õ����һ�����ֵ��±�
                                             for(int  i=n+1;i<label.length();i++)
                                              {
                                                  char c=label.charAt(i);
                                                  str.append(c);
                                              }	 String s=str.toString();
                                                 data=Integer.toString(s);
                                                label=label.subtring(0,n+1);//��ȡ�������һλ�����������ʽ
                                              String text=Integer.toString(Fn(data));
                                              text+=label;
                                              inputField.setText(text);       
                                                                                              
         }

//�ݹ���׳�
public int Fn(int n)
       {
        if(n==1)
           return 1;
         return n*Fn(n-1);
    }
*/





//������
public void handleResult()
		{
			String text=inputField.getText();
			try 
			{
				Object a=jse.eval(text);          //jse.eval()ֱ�Ӽ����ַ�����ʽ
				text=String.valueOf(a);         //������ת�����ַ���
				inputField.setText(text);
			} 
			catch (ScriptException e) 
			{
				e.printStackTrace();
				inputField.setText("��ʽ��ʽ����ȷ!");
			}
		}


public static void main (String [] args)
   {
                                   Calculator c=new Calculator();
   
    }



//��������
/*public void handleNum(String label)
             {
            if(firstdigit)
                 {
                   inputField.setText(label);
                 }
              else if(label.equals(".")&&(inputField.getText().indexof(".")<0)//
          }*/

}



                   

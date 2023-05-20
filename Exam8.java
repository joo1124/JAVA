import javax.swing.*;
import java.awt.*;

public class Exam8 extends JFrame {
	public Exam8() {
        setTitle("여러 개의 패널을 가진 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        JPanel pn = new JPanel();
        JPanel pc = new JPanel();
        JPanel ps = new JPanel();

        pc.setLayout(null);

        c.add(pn, BorderLayout.NORTH);
        c.add(pc);
        c.add(ps, BorderLayout.SOUTH);
        
        for (int i=0; i<4; i++) {
            JButton btn = new JButton();
            String[] str = {"열기", "닫기", "나가기", "Word Input"};
            btn.setText(str[i]);
            if(i<3) {
                pn.add(btn);
            } else {
                ps.add(btn);
            }
        }
        
        pn.setBackground(Color.GRAY);
        ps.setBackground(Color.YELLOW);
        JTextField stf = new JTextField(10);
        ps.add(stf);
        
        for(int i=0; i<10; i++) {
            int x = (int)(Math.random()*200)+10;
            int y = (int)(Math.random()*200)+10;

            JLabel la = new JLabel("*");
            la.setForeground(Color.RED);
            la.setLocation(x,y);
            la.setSize(30,30);
            pc.setOpaque(true);
            pc.add(la);
        }
        setSize(400,400);
        setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Exam8();
	}
}

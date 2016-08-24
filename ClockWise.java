import java.applet.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
//<applet code ="ClockWise" height=800 width=1200></applet>
public class ClockWise extends Applet
{ 
	public void paint(Graphics g2)
	{
		Graphics2D g = (Graphics2D)g2;
		double x=1068,y=660.0602994749202,n=13,f,u=0,v=0,m=2*y,w=90,s=90,p=13;
		double[] l;
		l=new double[15];
		l[0]=y;
		l[1]=x-y;
		double a=y,b=0,c=y,d=y;
		g.draw(new Rectangle2D.Double(0,0,x,y));
		g.draw(new Line2D.Double(a,b,c,d));
		for(int i=2;i<=n;i++)
		l[i]=l[i-2]-l[i-1];
		g.draw(new Arc2D.Double(u,v,m,m,w,s,Arc2D.OPEN));
		for(int i=1;i<=n;i++)
		{
			if(i%2==0)
			{
				if(i%4==0)
				{
					d=b-l[i];
					a=a-l[i+1];
					c=a;
					v=d;
					w=90;
					s=90;
				}
				else
				{
					d=b+l[i];
					a=a+l[i+1];
					c=a;
					v=d-(2*l[i]);
					w=0;
					s=-90;
				}
				u=c-l[i];
			}
			else
			{
				b=0;
				f=0;
				for(int k=1;f!=1;k++)
				{
					if((4*k-3)%i==0)
					{
						for(int j=1;j<=i;j+=4)
							b=b+l[j];
						c=a+l[i];
						d=b;
						f=1;
						u=c-(2*l[i]);
						w=0;
					}
					else if((4*k-1)%i==0)
					{
						for(int j=3;j<=i;j+=4)
							b=b+l[j];
						c=a-l[i];
						b=y-b;
						d=b;
						f=1;
						u=c;
						w=180;
					}
				}
				v=d-l[i];
				s=90;
			}
			m=2*l[i];
			if(l[i]==0)
				p=i;
			if(i<=p)
			{
				g.draw(new Arc2D.Double(u,v,m,m,w,s,Arc2D.OPEN));
				g.draw(new Line2D.Double(a,b,c,d));
			}
			System.out.println(l[i]+"."+a+"."+b+"."+c+"."+d);
			try
			{
				Thread.sleep(100);
			}
			catch(Exception e)
			{}
		}
	}
}
import java.applet.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
//<applet code="AntiClockWise" width=1200 height=800></applet>
public class AntiClockWise extends Applet
{
// Constructor
	public void paint(Graphics g2)
	{
		Graphics2D g = (Graphics2D)g2; // Get a 2D device context
		double x=1068,y=660.0602994749202,n=13,u=0,v=0,w=0,p=n;
		double[] l;
		l=new double[15];
		l[0]=y;
		l[1]=x-y;
		double a=x-y,b=0,c=x-y,d=y;
		g.draw(new Rectangle2D.Double(0,0,x,y));
		g.draw(new Line2D.Double(a,b,c,d));
		for(int i=2;i<n;i++)
		l[i]=l[i-2]-l[i-1];
		g.draw(new Arc2D.Double(a-l[0],b,2*l[0],2*l[0],w,90,Arc2D.OPEN));
		for(int i=1;i<=n;i++)
		{
			if(i==1)
			{
				d=b=c;
				c=0;
				u=a-l[i];
				v=b-l[i];
				w=90;
			}
			if(i>1)
			{
				if(i%2==0)
				{
					if(i%4==0)
					{
						a=a+l[i+1];
						d=d-l[i];
						v=d;
						w=0;
					}
					else
					{
						a=a-l[i+1];
						d=d+l[i];
						v=d-2*l[i];
						w=180;
					}
					c=a;
					u=c-l[i];
				}
				else
				{
					if((i+1)%4==0)
					{
						b=b+l[i+1];
						c=c+l[i];
						u=a-l[i];
						w=270;
					}
					else
					{
						b=b-l[i+1];
						c=c-l[i];
						u=a-l[i];
						w=90;
					}
					d=b;
					v=b-l[i];
				}
			}
			if(l[i]==0)
				p=i;
			if(p==i)
				break;
			g.draw(new Arc2D.Double(u,v,2*l[i],2*l[i],w,90,Arc2D.OPEN));
			g.draw(new Line2D.Double(a,b,c,d));
			System.out.println(l[i]+"."+a+"."+b+"."+c+"."+d);
			try
			{	
				Thread.sleep(100);
			}
			catch(Exception e)
			{}
		}
	}
// Points for quadratic curve
}

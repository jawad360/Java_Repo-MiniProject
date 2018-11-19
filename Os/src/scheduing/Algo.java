package scheduing;

public class Algo 
{
	int m=0;
	String[] str;
	void comp(String subT[][],int noc, int days, int lect)
	{
		str = new String[subT.length*subT[0].length];
		
		for(int i=0;i<subT[0].length;i++)
			for(int j=0;j<subT.length;j++)
			{
				if(subT[j][i]!=null)
				{
					str[m] = subT[j][i];
					m++;
				}
			}
		
		String tt[][][] = new String[noc][days][lect];
		m=0;
		for(int i=0;i<days;i++)
		{
			for(int j=0;j<lect;j++)
			{
				for(int k=0;k<noc;k++)
				{
					if(str[m]!=null)
					{
						tt[k][i][j] = str[m];
						m++;
					}
					else
					{
						m=0;
						k--;
					}
					
				}
			}
		}
		
		new Class().start(tt,lect);
	}
}

#include<stdio.h>
#include <stdlib.h>
#include<math.h>
#include<time.h>

int g=0;//������ȷ��Ŀ

float jia(float a,float b)
{
	float x;
	x=a+b;
	return x;
}

float jian(float a,float b)
{
	float x;
	x=a-b;
	return x;
}

float chen(float a,float b)
{
	float x;
	x=a*b;
	return x;
}

float chu(float a,float b)
{
	float x;
	x=a/b;
	return x;
}
float jisuan(int i,float a,float b)
{
	float x;
	switch(i)
	{
	case 0:
		x=jia(a,b);
		break;
	case 1:
		x=jian(a,b);
		break;
	case 2:
		x=chen(a,b);
		break;
	case 3:
		x=chu(a,b);
		break;
	default:
		break;
	}
	return x;
}

char fuhao(int i)
{
	char p;
	switch(i)
	{
	case 0:
		p='+';
		break;
	case 1:
		p='-';
		break;
	case 2:
		p='*';
		break;
	default:
		p='/';
		break;
	}
	return p;
}
void caozuo()
{
	float answer;
	float x,y,z;
	int a,b,c;
	int j,k;
	char p1,p2;
	srand((unsigned)time(NULL));
	do{
		a=rand()%100;
		b=rand()%100;
		c=rand()%100;
		j=rand()%4;
		k=rand()%4;
		if(j>1){
			y=(float)a;
			z=(float)b;
			x=jisuan(j,y,z);
			y=x;
			z=(float)c;
			x=jisuan(k,y,z);
		}
		else
		{
			if(k<2)
			{
				y=(float)a;
			    z=(float)b;
			    x=jisuan(j,y,z);
			    y=x;
			    z=(float)c;
			    x=jisuan(k,y,z);
			}
			else
			{
				y=(float)b;
			    z=(float)c;
		    	x=jisuan(k,y,z);
			    y=(float)a;
			    z=x;
		    	x=jisuan(j,y,z);
			}
		}
	}while(x<0.0);
	p1=fuhao(j);
	p2=fuhao(k);
	printf("%d %c %d %c %d = ",a,p1,b,p2,c);
	scanf("%f",&answer);
	if(j==3 && k==3)
	{
		if((answer-x)<0.01)
		{
			printf("��ϲ��,�����ˣ�\n");
			g++;
		}
		else
		{
			printf("�Բ��������ˣ���ȷ���ǣ�%.1f\n",x);
		}
	}
	else
	{
		if((x-answer)<0.01)
		{
			printf("��ϲ��,�����ˣ�\n");
			g++;
		}
		else
		{
			printf("�Բ��������ˣ���ȷ���ǣ�%.1f\n",x);
		}
	}
}


main()
{
	int f=0,s,n;//fΪ������Ŀ�ķ���
	printf("��ʾ:\n1.�𰸶��Ǿ�ȷ��С�����һλ\n2.����Ϊ100��\n\n");
	printf("������������ʽ��Ŀ:");
	scanf("%d",&n);
	for(s=0;s<n;s++)
	{
		caozuo();
	}

	f=100/n*g;
	printf("\n�ܹ����%d����\n",g);
	printf("���÷�Ϊ%d��\n",f);
}

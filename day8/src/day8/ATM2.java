package day8;
import java.util.Scanner;
public class ATM2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int MAX = 5;
		int arrID[] = new int[MAX];
		int arrPW[] = new int[MAX];
		int Money[] = new int[MAX];
		int log = -1; // �α����ϸ� +1 �α׾ƿ��ϸ� -1
		int count = 0;
		
		
		
		
		while(true)
		{
			System.out.println("=== �ް� IT ATM ===\n");
			System.out.println("1. ȸ������");
			System.out.println("2. ȸ��Ż��");
			System.out.println("3. �α���");
			System.out.println("4. �α׾ƿ�");
			System.out.println("5. �Ա�");
			System.out.println("6. ��ü");
			System.out.println("7. �ܾ���ȸ");
			System.out.println("8. ����");
			
			System.out.println("�̿��Ͻ� �޴��� �����ϼ���");
			int select = sc.nextInt();
			
			
			if(select == 1) //ȸ������
			{
				
				for(int k = 0; k<5;k++)
				System.out.println(arrID[k]);
				System.out.println("����� ID�� �Է��ϼ���");
				int dataID = sc.nextInt();
				int dataPW = 0;
				for(int i = 0; i<arrID.length; i++)
				{
					if(arrID[i] == 0)
					{
						arrID[i] = dataID;
						System.out.println("����� PW�� �Է��ϼ���(0�� �Է�����������)");
						 dataPW = sc.nextInt();
						if(arrPW[i] == 0)
						{
							arrPW[i] = dataPW;
							Money[i] = 1000;
							System.out.println("1000���� �ԱݵǾ����ϴ�");
						}
						break;
					}
					
					else if(arrID[i] == dataID)
					{
						System.out.println("�ߺ��� ID�Դϴ�");
						break;
					}
				
				if(dataPW != 0)
				{
					break;
				}
				
				}
			}
			if(select == 3)// �α���
			{
				System.out.println("�α����� ID�� �Է��ϼ���");
				int inID = sc.nextInt();
				
				for(int i = 0; i<arrID.length;i++)
				{
					if(arrID[i] == inID)
					{
						System.out.println("�α����� PW�� �Է��ϼ���");
						int inPW = sc.nextInt();
						if(arrPW[i] == inPW)
						{
							log += 1;
							count +=1;
							System.out.println("�α����� �Ϸ�Ǿ����ϴ�");
						}
						else
						{
							System.out.println("�Է��� ������ ��ġ���� �ʽ��ϴ�");
						}
					}
				}
			}
			if (select == 2) {
				while(true){
					if (count != 0 || log != -1) {
						System.out.println("Ż���� ID�� �Է��ϼ���");
						int delID = sc.nextInt();

						for (int i = 0; i < 5; i++) 
						{
							if (arrID[i] == delID)
							{
								for(int k=0; k<5; k++) 
								{
									if(i>k)
									{
									
										arrID[i] = 0;
									arrID[i] = arrID[i-k];
									arrID[i-k] = arrID[k];
									}
										
								
								}
								count -=1;
								System.out.println("ȸ��Ż�� �Ϸ�Ǿ����ϴ�");
								break;
							}
					
							else if(arrID[i] != delID)
							{
								System.out.println("ID�� ��ġ���� �ʽ��ϴ�");
								break;
							}
						}
						break;
					} 
					else
					{
						System.out.println("�α��νÿ��� �̿밡���մϴ�");
						break;
					}
				}
			}
			
			if(select == 4)//�α׾ƿ�
			{
				if(log == 0)
				{
					System.out.println("�α׾ƿ��� ���̵� �Է��ϼ���");
					int outID = sc.nextInt();
					for(int i = 0; i<arrID.length;i++)
					{
						if(arrID[i] == outID)
						{
							log = -1;
							System.out.println("�α׾ƿ� �Ǿ����ϴ�");
						}
					}
				}
				else
				{
					System.out.println("�α��νÿ��� �̿밡���մϴ�");
					break;
				}
			}
			
			if(select == 5)//�Ա�
			{
				if(log == 0) {
				System.out.println("����Ȯ�ο� ���̵� �Է��ϼ���");
				int moneyID = sc.nextInt();
					for(int i = 0; i<Money.length;i++)
					{
						if(moneyID == arrID[i])
						{
							System.out.println("�Ա��� �ݾ��� �Է��ϼ���");
							int inMoney = sc.nextInt();
							Money[i] += inMoney;
							System.out.println(Money[i]);
						}
					}
				}
				else
				{
					System.out.println("�α��νÿ��� �̿밡���մϴ�");
				}
			}
			if(select == 6)//��ü
			{
				if(log == 0)
				{
				System.out.println("����Ȯ�ο� ���̵� �Է��ϼ���");
				int checkID = sc.nextInt();
				for(int i = 0; i<arrID.length;i++)
				{
				if(checkID == arrID[i])
				{
					for(int j = 0; j<arrID.length;j++)
					{
						if(arrID[i] != arrID[j])
						{
							System.out.println("��ü�� ���̵� �Է��ϼ���");
							int sendID = sc.nextInt();
							
							System.out.println("��ü�� �ݾ��� �Է��ϼ���");
							int sendMoney = sc.nextInt();
							Money[j] -= sendMoney;
							if(Money[j] == sendID)
							{
								Money[j] += sendMoney;
								
							System.out.println("��ü�� �Ϸ�Ǿ����ϴ�");
							break;
							}
						break;
						}
					}
				}
			}	
		}
				else
				{
					System.out.println("�α��ν� �̿밡���մϴ�");
				}
	}
				if(select == 7)
				{
					if(log == 0)
					{
						System.out.println("����Ȯ�ο� ���̵� �Է��ϼ���");
						int checkID2 = sc.nextInt();
			
						for(int i = 0; i<5;i++)
						{
							if(checkID2 == arrID[i])
							{
								System.out.println("���¿� "+Money[i]+"�� �ֽ��ϴ�");
							}
						}
					}
					else
					{
						System.out.println("�α��ν� �̿밡���մϴ�");
					}
				}
	
				if(select == 8)
				{
					System.out.println("ATM�� �����մϴ�...");
					break;
				}
			}
		}
	}

				
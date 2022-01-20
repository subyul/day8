package day8;
import java.util.Scanner;
public class ATM2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int MAX = 5;
		int arrID[] = new int[MAX];
		int arrPW[] = new int[MAX];
		int Money[] = new int[MAX];
		int log = -1; // 로그인하면 +1 로그아웃하면 -1
		int count = 0;
		
		
		
		
		while(true)
		{
			System.out.println("=== 메가 IT ATM ===\n");
			System.out.println("1. 회원가입");
			System.out.println("2. 회원탈퇴");
			System.out.println("3. 로그인");
			System.out.println("4. 로그아웃");
			System.out.println("5. 입금");
			System.out.println("6. 이체");
			System.out.println("7. 잔액조회");
			System.out.println("8. 종료");
			
			System.out.println("이용하실 메뉴를 선택하세요");
			int select = sc.nextInt();
			
			
			if(select == 1) //회원가입
			{
				
				for(int k = 0; k<5;k++)
				System.out.println(arrID[k]);
				System.out.println("사용할 ID를 입력하세요");
				int dataID = sc.nextInt();
				int dataPW = 0;
				for(int i = 0; i<arrID.length; i++)
				{
					if(arrID[i] == 0)
					{
						arrID[i] = dataID;
						System.out.println("사용할 PW를 입력하세요(0을 입력하지마세요)");
						 dataPW = sc.nextInt();
						if(arrPW[i] == 0)
						{
							arrPW[i] = dataPW;
							Money[i] = 1000;
							System.out.println("1000원이 입금되었습니다");
						}
						break;
					}
					
					else if(arrID[i] == dataID)
					{
						System.out.println("중복된 ID입니다");
						break;
					}
				
				if(dataPW != 0)
				{
					break;
				}
				
				}
			}
			if(select == 3)// 로그인
			{
				System.out.println("로그인할 ID를 입력하세요");
				int inID = sc.nextInt();
				
				for(int i = 0; i<arrID.length;i++)
				{
					if(arrID[i] == inID)
					{
						System.out.println("로그인할 PW를 입력하세요");
						int inPW = sc.nextInt();
						if(arrPW[i] == inPW)
						{
							log += 1;
							count +=1;
							System.out.println("로그인이 완료되었습니다");
						}
						else
						{
							System.out.println("입력한 정보가 일치하지 않습니다");
						}
					}
				}
			}
			if (select == 2) {
				while(true){
					if (count != 0 || log != -1) {
						System.out.println("탈퇴할 ID를 입력하세요");
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
								System.out.println("회원탈퇴가 완료되었습니다");
								break;
							}
					
							else if(arrID[i] != delID)
							{
								System.out.println("ID가 일치하지 않습니다");
								break;
							}
						}
						break;
					} 
					else
					{
						System.out.println("로그인시에만 이용가능합니다");
						break;
					}
				}
			}
			
			if(select == 4)//로그아웃
			{
				if(log == 0)
				{
					System.out.println("로그아웃할 아이디를 입력하세요");
					int outID = sc.nextInt();
					for(int i = 0; i<arrID.length;i++)
					{
						if(arrID[i] == outID)
						{
							log = -1;
							System.out.println("로그아웃 되었습니다");
						}
					}
				}
				else
				{
					System.out.println("로그인시에만 이용가능합니다");
					break;
				}
			}
			
			if(select == 5)//입금
			{
				if(log == 0) {
				System.out.println("본인확인용 아이디를 입력하세요");
				int moneyID = sc.nextInt();
					for(int i = 0; i<Money.length;i++)
					{
						if(moneyID == arrID[i])
						{
							System.out.println("입금할 금액을 입력하세요");
							int inMoney = sc.nextInt();
							Money[i] += inMoney;
							System.out.println(Money[i]);
						}
					}
				}
				else
				{
					System.out.println("로그인시에만 이용가능합니다");
				}
			}
			if(select == 6)//이체
			{
				if(log == 0)
				{
				System.out.println("본인확인용 아이디를 입력하세요");
				int checkID = sc.nextInt();
				for(int i = 0; i<arrID.length;i++)
				{
				if(checkID == arrID[i])
				{
					for(int j = 0; j<arrID.length;j++)
					{
						if(arrID[i] != arrID[j])
						{
							System.out.println("이체할 아이디를 입력하세요");
							int sendID = sc.nextInt();
							
							System.out.println("이체할 금액을 입력하세요");
							int sendMoney = sc.nextInt();
							Money[j] -= sendMoney;
							if(Money[j] == sendID)
							{
								Money[j] += sendMoney;
								
							System.out.println("이체가 완료되었습니다");
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
					System.out.println("로그인시 이용가능합니다");
				}
	}
				if(select == 7)
				{
					if(log == 0)
					{
						System.out.println("본인확인용 아이디를 입력하세요");
						int checkID2 = sc.nextInt();
			
						for(int i = 0; i<5;i++)
						{
							if(checkID2 == arrID[i])
							{
								System.out.println("계좌에 "+Money[i]+"원 있습니다");
							}
						}
					}
					else
					{
						System.out.println("로그인시 이용가능합니다");
					}
				}
	
				if(select == 8)
				{
					System.out.println("ATM을 종료합니다...");
					break;
				}
			}
		}
	}

				
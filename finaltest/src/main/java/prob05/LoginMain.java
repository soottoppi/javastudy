package prob05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		List<User> joinUsers = new ArrayList<User>();
		joinUsers.add( new User( "둘리", "1234") );
		joinUsers.add( new User( "마이콜", "5678") );
		joinUsers.add( new User( "또치", "4321") );
		joinUsers.add( new User( "도우너", "8765") );
		
		System.out.print("아이디를 입력하시오 : ");
		String id = scanner.nextLine();
		
		System.out.print("비밀번호를 입력하시오 : ");
		String password = scanner.nextLine();

		try {
			login(joinUsers, new User( id, password) );
			System.out.println("로그인 성공");
		} catch (UserNotFoundException ex) {
			System.out.println("사용자를 찾을 수 없습니다.");
			return;
		} catch( PasswordDismatchException ex ){
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		} finally {
			scanner.close();
		}
	}
	
	public static void login(List<User> users, User user ) {
		/* 코드 작성 */
		// 1 	리스트를 돌린다
		// 2	매개변수로 넘어온 객체가 User 객체인지 체크
		// 3 	id가 틀리면 다음 리스트로 continue
		// 4 	id가 맞으면 pw를 체크한다.
		// 5	pw가 틀리면 PasswordDismatchException 예외 발생
		// 6	pw가 맞으면 return
		// 7	모든 리스트를 체크 후 빠져 나왔을 경우 해당 id가 없는것으로 판단
		// 8	UserNotFoundException 예외 발생
		for(User userList : users) {
 			if(user instanceof User) {
				if(!userList.getId().equals(user.getId())) {
					continue;
				} else if(!userList.getPassword().equals(user.getPassword())) {
					throw new PasswordDismatchException();	// id는 일치하지만 pw를 틀릴 경우 예외 발생
				} else {
					return;
				}
			}
		}
		throw new UserNotFoundException();	// 리스트를 다 돌려도 해당 id가 없으면 예외 발생
	}
}

INSERT INTO users (id, pw, name, nickname, email, phone, address)
VALUES ("ssafy", "1234", "강준규", "강준규", "ssafy@ssafy.com", "010-1111-1111", "seoul"),
("ssafy2", "1234", "고은석", "고은석", "ssafy2@ssafy.com", "010-2222-2222", "iksan"),
("ssafy3", "1234", "권준구", "권준구", "ssafy3@ssafy.com", "010-3333-3333", "pyungteak"),
("ssafy4", "1234", "박지운", "박지운", "ssafy4@ssafy.com", "010-4444-4444", "gunsan"),
("ssafy5", "1234", "오건영", "오건영", "ssafy5@ssafy.com", "010-5555-5555", "daejeon"),
("abcde6", "1234", "이호진", "이호진", "ssafy6@ssafy.com", "010-6666-6666", "idonknow"),
("abcde7", "1234", "최준호", "최준호", "ssafy7@ssafy.com", "010-7777-7777", "incheon"),
("abcde8", "1234", "서만기", "서만기", "ssafy8@ssafy.com", "010-8888-8888", "masan"),
("abcde9", "1234", "유호정", "유호정", "ssafy9@ssafy.com", "010-9999-9999", "chunan"),
("abcde10", "1234", "심규리", "심규리", "ssafy10@ssafy.com", "010-0000-0000", "gunpo");

INSERT INTO diarys (userid, title, content, date, img)
VALUES ("ssafy", "단체사진", "첫 단체사진", "20231124", "첫 단체사진.jpeg"),
("ssafy", "전신운동", "온몸이 아프다..", "20231107", ""),
("ssafy", "하체운동", "다리가 저리다..", "20231116", ""),
("ssafy", "상체운동", "상체가 아프다..", "20231120", ""),
("ssafy2", "A형끝나고치킨", "A형끝나고치킨", "20231111", "A형끝나고치킨.jpeg"),
("ssafy2", "날좋은날단체", "날좋은날단체", "20231122", "날좋은날단체.jpeg"),
("ssafy3", "스티커사진", "스티커사진", "20231122", "스티커사진.jpeg"),
("ssafy4", "비눗방울", "비눗방울", "20231111", "비눗방울.jpeg"),
("ssafy4", "윷놀이", "윷놀이", "20231122", "윷놀이.jpeg"),
("ssafy5", "인생네컷", "인생네컷", "20231111", "인생네컷.jpeg"),
("ssafy5", "춤추는개", "춤추는개", "20231122", "춤추는개.jpeg"),
("abcde6", "하테", "하테", "20231111", "하테.jpeg"),
("abcde7", "할로윈", "할로윈", "20231122", "할로윈.jpeg"),
("abcde8", "불태웠다", "불태웠다", "20231111", "불태웠다.jpeg");



INSERT INTO todos (diaryid, userid, date, workout, start_hour, start_minute, end_hour, end_minute)
VALUES (1, "ssafy", "20231124", "마무리 및 발표 준비", 9, 00, 12, 30),
(1, "ssafy", "20231124", "점심 식사", 12, 30, 13, 30),
(1, "ssafy", "20231124", "발표", 14, 00, 17, 00);

INSERT INTO comments (diaryid, userid, nickname, content)
VALUES (1, "ssafy", "닉네임 test", "content test"),
(1, "ssafy", "닉네임 test", "content test"),
(1, "ssafy", "닉네임 test", "content test"),
(1, "ssafy", "닉네임 test", "content test");

INSERT INTO follows 
VALUES ("ssafy", "ssafy2"), ("ssafy", "ssafy3"), ("ssafy", "ssafy4"), ("ssafy", "ssafy5"),
("ssafy","abcde6"), ("ssafy","abcde7"), ("ssafy","abcde8"), ("ssafy","abcde9"), ("ssafy","abcde10");

INSERT INTO follows
VALUES ("ssafy2", "ssafy"), ("ssafy3", "ssafy"), ("ssafy4", "ssafy"), ("abcde6", "ssafy"), ("abcde7", "ssafy"), ("abcde8", "ssafy"), ("abcde9", "ssafy");
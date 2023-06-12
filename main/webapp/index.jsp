<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<title>와이파이 정보 구하기</title>
	<link href="/res/css/main.css" rel="stylesheet"/>
	<script src="/res/js/index.js"></script>
</head>

<body>
	<h1>와이파이 정보 구하기</h1>
	<a href="/">홈</a> | <a href="/history">위치 히스토리 목록</a> | <a href="/loadWifi">Open API 와이파이 정보 가져오기</a>
	<form>
		LAT : <input id="inputLat" type="text" name ="LAT" maxlength="10">, LNT : <input id="inputLnt" type="text" name="LNT" maxlength="10">
		<input id="getPositionButton" type='button' value='내 위치 가져오기'/> <input id="getWifiButton" type='button' value='근처 WIPI 정보 보기'/>

		<table class="table-list">
			<thead>
				<tr>
					<th>거리(Km)</th>
					<th>관리 번호</th>
					<th>자치구</th>
					<th>와이파이 명</th>
					<th>도로명 주소</th>
					<th>상세 주소</th>
					<th>설치 위치(🏠)</th>
					<th>설치 유형</th>
					<th>설치 기관</th>
					<th>서비스 구분</th>
					<th>망 종류</th>
					<th>설치년도</th>
					<th>실내 외 구분</th>
					<th>WIFI 접속 환경</th>
					<th>X좌표</th>
					<th>Y좌표</th>
					<th>작업일자</th>
				</tr>
			</thead>
			<tbody>
				<td colspan="17">위치 정보를 입력 한 후에 조회해 주세요.</td>
			</tbody>
		</table>

	</form>
</body>
</html>
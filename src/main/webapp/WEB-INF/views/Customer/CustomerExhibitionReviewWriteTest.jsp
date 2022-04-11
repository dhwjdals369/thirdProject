<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css'
	rel='stylesheet' type='text/css'>

<style>
* {
	font-family: 'Spoqa Han Sans Neo', 'sans-serif';
}
</style> -->
<title>Insert title here</title>
</head>
<body>

	<h1>글 등록</h1>
	<hr>
	<form action="/exhibition/saveReview.do" method="post">
		<!--  enctype="multipart/form-data" -->
		<table border="1" cellpadding="0" cellspacing="0">

			<tr>
				<td>제목</td>
				<td align="left"><input type="text" name="review_title"
					size="10" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td align="left"><textarea name="review_contents" cols="40"
						rows="10"></textarea></td>
			</tr>

			<tr>
				<td width="70">별점</td>
				<td align="left"><input type="number" name="review_star_score" /></td>
			</tr>
			<tr>
				<td width="70">이미지</td>
				<td align="left"><input type="file" name="review_image" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value=" 새글 등록 " /></td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="ExhibitionReviewListTest.do">글 목록 가기</a>





</body>
</html>
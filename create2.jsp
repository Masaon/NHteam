<h1>${param.name}の作成</h1>

<form action="create">

	<input type="hidden" name="cmd" value="create">
	<input type="hidden" name="name" value="${param.name}">
	
	<textarea rows="15" cols="60" name="content" required></textarea><br>
	<br>
	<input type="submit" value=" 作成 ">
	<input type="button" value="キャンセル" onclick="location.href='refer'">

</form>
<!-- -->
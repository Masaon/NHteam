<H1>${param.name}�̍쐬</h1>

<FROM ACTION="create">

	<INPUT TYPE="HIDDEN" NAME="cmd" VALUE="create">
	<INPUT TYPE="HIDDEN" NAME="name" VALUE="${param.name}">
	
	<TEXTAREA ROWS="15" COLS="60" NAME="content"></TEXTAREA>
	
	<BR>
	<INPUT TYPE="SUBMIT" VALUE=" �쐬 ">
	<INPUT TYPE="BUTTON" VALUE="�L�����Z��"
		   ONCLICK="location.href='refer'">

</FORM>

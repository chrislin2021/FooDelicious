<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="/css/CKEditor.css" rel="stylesheet" />
<!-- 開工啦!!! -->
<div class="row" id="rowSelect">
	<div div class="col-12 col-md-2"></div>


	<div div class="col-12 col-md-9">
		<h3>發表新文章</h3>
		<select class="form-select selectpicker" aria-label="Default select"
			data-width="300px">
			<option selected>請選擇分類</option>
			<option>食譜分享</option>
			<option>廚具開箱</option>
		</select>
		<div style="margin: 10px 0px;">
			<input type="text" class="form-control" placeholder="請輸入文章標題..."
				aria-label="Recipient's username">
		</div>
		<form action="[URL]" method="post">
			<textarea name="content" id="editor">           
        </textarea>
			<p>
				<input type="submit" value="Submit">
			</p>
		</form>


	</div>
</div>
<script src="/js/ckeditor.js"></script>
<script src="/translations/zh.js"></script>

<script>
        ClassicEditor
            .create(document.querySelector('#editor'), {
                language: "zh",
                ckfinder: {
                    uploadUrl: 'http://localhost:8080/postArticle?command=QuickUpload&type=Files&responseType=json',
                    currentFolder: {
                        "path": "/",
                        "url": "/img",
                        "acl": 255
                    },
                },

            })
            .then( editor => {
        		window.editor = editor;
        	} )
            .catch(error => {
                console.error(error);
            });
    </script>
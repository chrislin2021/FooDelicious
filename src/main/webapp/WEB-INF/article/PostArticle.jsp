<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



    <link href="/css/CKEditor.css" rel="stylesheet" />
    <!-- 開工啦!!! -->
    <div class="row" id="rowSelect">
        <div div class="col-12 col-md-2"></div>


        <div div class="col-12 col-md-9">
            <h3>發表新文章</h3>
            <select class="form-select selectpicker" aria-label="Default select" data-width="300px">
			<option selected>請選擇分類</option>
			<option>食譜分享</option>
			<option>廚具開箱</option>
		</select>
            <div style="margin: 10px 0px;">
                <input type="text" class="form-control" placeholder="請輸入文章標題..." aria-label="Recipient's username">
            </div>
            <form action="#" method="post" enctype="multipart/form-data">
                <textarea name="content" id="editor">           
        </textarea>
                <p>
                    <input type='button' value='送出' onclick='processData()'>
                </p>
            </form>


        </div>
    </div>
    <script src="/js/ckeditor.js"></script>
    <script src="/translations/zh.js"></script>
    <script type="module">
        import Image from '@ckeditor/ckeditor5-image/src/image'; import ImageResizeEditing from '@ckeditor/ckeditor5-image/src/imageresize/imageresizeediting'; import ImageResizeHandles from '@ckeditor/ckeditor5-image/src/imageresize/imageresizehandles';
    </script>
    <script type="text/javascript">
        class MyUploadAdapter {
            constructor(loader) {
                // The file loader instance to use during the upload.
                this.loader = loader;
            }

            // Starts the upload process.
            upload() {
                return this.loader.file
                    .then(file => new Promise((resolve, reject) => {
                        this._initRequest();
                        this._sendRequest(file);
                    }));
            }

            // Aborts the upload process.
            abort() {
                if (this.xhr) {
                    this.xhr.abort();
                }
            }

            // Initializes the XMLHttpRequest object using the URL passed to the constructor.
            _initRequest() {
                const xhr = this.xhr = new XMLHttpRequest();

                // Note that your request may look different. It is up to you and your editor
                // integration to choose the right communication channel. This example uses
                // a POST request with JSON as a data structure but your configuration
                // could be different.
                xhr.open('POST', '/imgArticle', true);
                xhr.responseType = 'json';
            }



            // Prepares the data and sends the request.
            _sendRequest(file) {
                // Prepare the form data.
                const data = new FormData();

                data.append('upload', file);

                // Important note: This is the right place to implement security mechanisms
                // like authentication and CSRF protection. For instance, you can use
                // XMLHttpRequest.setRequestHeader() to set the request headers containing
                // the CSRF token generated earlier by your application.

                // Send the request.
                this.xhr.send(data);
            }
        }

        // ...

        function MyCustomUploadAdapterPlugin(editor) {
            editor.plugins.get('FileRepository').createUploadAdapter = (loader) => {
                // Configure the URL to the upload script in your back-end here!
                return new MyUploadAdapter(loader);
            };
        }

        // ...

        ClassicEditor
            .create(document.querySelector('#editor'), {
                extraPlugins: [MyCustomUploadAdapterPlugin],
                plugins: [Image, ImageResizeEditing, ImageResizeHandles],
                language: "zh",
                // ...
            }).catch(error => {
                console.log(error)
            });

        function processData() {
            //var data = CKEDITOR.instances.content.getData();

            console.log(document.getElementById("editor").innerHTML)
                //alert(data);
        }
    </script>
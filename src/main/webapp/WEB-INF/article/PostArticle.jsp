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
                      <input type="submit" value="Submit">
                </p>
            </form>


        </div>
    </div>
    <script src="/js/ckeditor.js"></script>
    <script src="/translations/zh.js"></script>

    <script type="text/javascript">
    class MyUploadAdapter {
        constructor( loader ) {
            // CKEditor 5's FileLoader instance.
            this.loader = loader;

            // URL where to send files.
            this.url = '/imgArticle';
        }

        // Starts the upload process.
        upload() {
            return new Promise( ( resolve, reject ) => {
                this._initRequest();
                this._initListeners( resolve, reject );
                this._sendRequest();
            } );
        }

        // Aborts the upload process.
        abort() {
            if ( this.xhr ) {
                this.xhr.abort();
            }
        }

        // Example implementation using XMLHttpRequest.
        _initRequest() {
            const xhr = this.xhr = new XMLHttpRequest();

            xhr.open( 'POST', this.url, true );
            xhr.responseType = 'json';
        }

        // Initializes XMLHttpRequest listeners.
        _initListeners( resolve, reject ) {
            const xhr = this.xhr;
            const loader = this.loader;
            const genericErrorText = 'Couldn\'t upload file:' + ` ${ loader.file.name }.`;

            xhr.addEventListener( 'error', () => reject( genericErrorText ) );
            xhr.addEventListener( 'abort', () => reject() );
            xhr.addEventListener( 'load', () => {
                const response = xhr.response;

                if ( !response || response.error ) {
                    return reject( response && response.error ? response.error.message : genericErrorText );
                }

                // If the upload is successful, resolve the upload promise with an object containing
                // at least the "default" URL, pointing to the image on the server.
                resolve( {
                    default: response.url
                } );
            } );

            if ( xhr.upload ) {
                xhr.upload.addEventListener( 'progress', evt => {
                    if ( evt.lengthComputable ) {
                        loader.uploadTotal = evt.total;
                        loader.uploaded = evt.loaded;
                    }
                } );
            }
        }

        // Prepares the data and sends the request.
        _sendRequest() {
            const data = new FormData();

            data.append( 'upload', this.loader.file );

            this.xhr.send( data );
        }
    }

    function MyCustomUploadAdapterPlugin( editor ) {
        editor.plugins.get( 'FileRepository' ).createUploadAdapter = ( loader ) => {
            return new MyUploadAdapter( loader );
        };
    }

    ClassicEditor
        .create( document.querySelector( '#editor' ), {
            extraPlugins: [ MyCustomUploadAdapterPlugin ],
            language: "zh",
            // ...
        }).catch(error => {
            console.log(error);
        });
    </script>
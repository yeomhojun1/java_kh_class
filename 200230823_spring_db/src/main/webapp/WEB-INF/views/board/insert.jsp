<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<form method="post"
							action=${pageContext.request.contextPath}/board/insert
							enctype="multipart/form-data" class="">
							<input type="hidden" value="${member.memberId}" name="memberId">
							<div>
							제목 :
							<textarea rows="1" class="col-xl-12" name="boardTitle"></textarea>
							</div>
							<div>
						내용 : 
							<textarea rows="10" cols="20" name="boardContent" id="editor1"></textarea>
							</div>

							<input type="submit" value="저장">
</body>
	<script>
	const cloudName = "db7cajuz1";
	const unsignedUploadPreset = '<Your unsignedUploadPreset>';
		$(function() {
			CKEDITOR
					.replace(
							'editor1',
							{
								filebrowserUploadUrl : '${pageContext.request.contextPath}/board/upload'
							});
		});
		editor.on( 'fileUploadRequest', function(evt) {

			// Prepare request to Cloudinary
			var url = 'https://api.cloudinary.com/v1_1/'+cloudName+'/upload';
			var xhr = evt.data.fileLoader.xhr;
			xhr.open('POST', url, true);
			xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
			
			// Fill all necessary fields for Cloudinary
			var fd = new FormData();
			fd.append('upload_preset', unsignedUploadPreset);
			fd.append('folder', 'content/articles'); // Optional - place image at specific folder admin in Cloudinary
			fd.append('tags', 'browser_upload'); // Optional - add tag for image admin in Cloudinary
			fd.append('file', evt.data.fileLoader.file);
			
			// Send the request to Cloudinary server
			xhr.send(fd);

			// Prevented the default behavior.
			evt.stop();
		});

		// Change response to handle Cloudinary response
		editor.on( 'fileUploadResponse', function(evt) {

			// Prevent the default response handler.
			evt.stop();

			// Get XHR and response.
			var data = evt.data,
			xhr = data.fileLoader.xhr,
			response = JSON.parse(xhr.responseText);

			// Transfer the response to Ckeditor format
			data.uploaded = 1;
			data.fileName = response.public_id + '.' + response.format;
			data.url = response.secure_url;
		});
	</script>
</html>
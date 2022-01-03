<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>

	<div class="container mt-3">
		<h2>新增商品</h2>
		<p>請在此新增您的商品
		<form action="/saveProduct">
			商品分類：
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio"
					name="productCategories" id="productCategories" value="0">
				<label class="form-check-label" for="inlineRadio1">廚具</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio"
					name="productCategories" id="productCategories" value="1">
				<label class="form-check-label" for="inlineRadio2">食材</label>
			</div>
			<div class="row mb-3">
				<label for="inputEmail3" class="col-sm-1 col-form-label">分類名稱
					:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="productCategoriesName">
				</div>
			</div>
			<div class="row mb-3">
				<label for="inputPassword3" class="col-sm-1 col-form-label">商品名稱
					:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="productName">
				</div>
			</div>
			<div class="row mb-3">
				<label for="inputPassword3" class="col-sm-1 col-form-label">商品公司：</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="productCompany">
				</div>
			</div>
			<div class="row mb-3">
				<label for="inputPassword3" class="col-sm-1 col-form-label">商品價格
					:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="productPrice">
				</div>
			</div>
			<div class="row mb-3">
				<label for="inputPassword3" class="col-sm-1 col-form-label">商品圖片：</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="productPics">
				</div>
			</div>
			<div class="row mb-3">
				<label for="inputPassword3" class="col-sm-1 col-form-label">商品內容：</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="productContent">
				</div>
			</div>
			<div class="row mb-3">
				<label for="inputPassword3" class="col-sm-1 col-form-label">商品存量：</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="productStock">
				</div>
			</div>

			商品狀態：
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="productStatus"
					id="productStatus" value="0"> <label
					class="form-check-label" for="inlineRadio1">下架</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="productStatus"
					id="productStatus" value="1"> <label
					class="form-check-label" for="inlineRadio2">上架</label>
			</div>
			<div class="row mb-3">
				<label for="inputPassword3" class="col-sm-1 col-form-label">關鍵字：</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="inputPassword3">
				</div>
			</div>

			<button type="reset" class="btn btn-primary mt-3">重製</button>
			<button type="submit" class="btn btn-primary mt-3">提交</button>
		</form>
	</div>



</body>

    
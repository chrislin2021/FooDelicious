<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


//顯示資料用
        function showData(startItem,endItem){
            let txt = "<tr>";
            for (let i = startItem; i < endItem; i++) {
                txt += "<td class='align-middle'>"+productData[i].productName+"</td>"
                txt += "<td class='align-middle'>"+productData[i].productPrice+"</td>"
                txt += "<td class='align-middle'>"+productData[i].productStock+"</td>"
                txt += "<td class='align-middle'>"+productData[i].productStatus+"</td>"
                txt += "<td class='align-middle'>"+productData[i].productInsertDate+"</td>"
                txt += "<td class='align-middle'>"+productData[i].productSalesFigures+"</td>"
              
                txt += '<td class="align-middle">'+
                    '<form method="" >'+
                    '<input type="hidden" type="text" name="memupd" value=?>'+
                    '<input id="updateBtn" class="btn btn-outline-primary" type="button" value="更新">'+
                    '</form>'+
                    '</td>'
                txt += '<td class="mdata">'+
                    '<form method="" action="">'+
                    '<input type="hidden" type="text" name="empdel" value=?>'+
                    '<input id="delBtn" class="btn btn-outline-danger" type="button" value="刪除" onclick="">'+
                    '</form>'+
                    '</td></tr>'
            }
            $("#products").html(txt);
        }
    
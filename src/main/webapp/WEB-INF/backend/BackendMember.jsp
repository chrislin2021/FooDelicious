<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<head>
    <link rel="stylesheet" href="../../css/BackendMember.css">
</head>
<body>
<h1 class="tableName">
    會員列表
    <span class="littleName">Member List</span>
</h1>
<form action="" method="post">
    <div class="col-sm-2">
        <input class="keyWord keyWord1" type="text" name="accKeyWord" placeholder="請輸入帳號關鍵字...">
        <input class="keyWord btn btn-outline-secondary" type="submit" value="查詢" />
    </div>
</form>

<section class="content">
        <div class="col-xs-12">
            <table id="" class='table table-striped table-hover '>
                <thead>
                <tr>
                    <th class="col col1 table-primary">會員編號</th>
                    <th class="col col2 table-primary">會員帳號</th>
                    <th class="col col3 table-primary">會員照片</th>
                    <th class="col col4 table-primary">帳號狀態</th>
                    <th class="col col5 table-primary">會員姓名</th>
                    <th class="col col6 table-primary">會員性別</th>
                    <th class="col col7 table-primary">會員coin</th>
                    <th class="col col8 table-primary">會員折扣</th>
                    <th class="col col9 table-primary">會員email</th>
                    <th class="col col10 table-primary">會員電話</th>
                    <th class="col col11 table-primary">會員地址</th>
                    <th class="col col12 table-primary">會員生日</th>
                    <th class="col col13 table-primary">註冊日期</th>
                    <th class="col col14 table-primary">更新</th>
                    <th class="col col15 table-primary">刪除</th>
                </tr>
                </thead>
                <tbody id="members"></tbody>
            </table>
            <nav aria-label="Page navigation example ">
                <ul id="page" class="pagination justify-content-center"></ul>
            </nav>
    </div>
</section>
</div>
<%--<script language="javascript" type="text/javascript">--%>
<%--    function delConfirm(memid) {--%>
<%--        if(confirm("確定要刪除嗎")){--%>
<%--            window.location.href="MemDelete?memid="+memid;--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>

<script>
    const memberUrl = "http://localhost:8080/bkmembers"
    let memberData;

    $.ajax({
        url: memberUrl,
        type: "GET",
        success: function(memberAll){
            //將值傳到全域
            memberData = memberAll;

            //=================分頁功能================
            //最大頁數
            var maxPage;
            //目前顯示頁數
            let nowPage = 0;
            //每頁最大筆數
            let maxItems = 4;
            //設定起始編號
            let startItem = 0;
            //設定結束編號
            let endItem = maxItems;

            //讀回資料時就先顯示
            showData(startItem, endItem);

            //計算出最大頁數。
            if(memberAll.length % maxItems == 0){
                maxPage = Math.floor(memberAll.length / maxItems);
            }else{
                maxPage = (Math.floor(memberAll.length / maxItems))+1;
            }
            // alert("最大頁數：" + maxPage);
            //動態生成頁數
            let pageHtml = `<li class="page-item previous disabled pageMove"><a class="page-link">上一頁</a></li>`;
            for(let i=0; i<maxPage; i++){
                let pageNum = i+1;
                pageHtml += `<li id=`+ i +` class="page-item page pageNum pageMove"><a class="page-link">`+ pageNum +`</a></li>`;
            };
            pageHtml += `<li class="page-item next pageMove"><a class="page-link" >下一頁</a></li>`;
            $("#page").html(pageHtml);

            //綁定click事件
            $("#page").on("click",".page", function(){
                nowPage = ($(this).prop("id"))*1;//強制轉成數字型態
                $(".pageNum").prop("class","page-item page pageNum")
                $(this).prop("class","page-item page pageNum active")
                // alert("nawPage："+nowPage+ "資料型態："+typeof nowPage);
                //恢復上、下頁的功能
                $(".previous").prop("class", "page-item previous");
                $(".next").prop("class", "page-item next");
                // alert("nowPage："+nowPage+"maxPage："+maxPage);
                //計算是否是最後一頁
                if((nowPage)+1 >= maxPage){
                    startItem = nowPage * maxItems;
                    endItem = startItem + (memberAll.length % maxItems);
                }else{
                    startItem = nowPage * maxItems;
                    endItem = startItem + maxItems;
                }
                // alert("開始："+startItem+"結束："+endItem);
                showData(startItem, endItem);
            });

            //=======上一頁設定========
            $("#page").on("click", ".previous", function (){

                //恢復下一頁的功能
                $(".next").prop("class", "page-item next");

                let page = nowPage-1;

                $(".pageNum").prop("class","page-item page pageNum")
                $("#"+page).prop("class","page-item page pageNum active")

                //判斷是否已經是第一頁了，取消上一頁功能
                if(page <= 0 ){
                    $(".previous").prop("class", "page-item previous disabled");
                    startItem = 0 * maxItems;
                    endItem = startItem + maxItems;
                }else{
                    startItem = page * maxItems;
                    endItem = startItem + maxItems;
                }
                showData(startItem, endItem);
                nowPage = page;
            });

            //========下一頁設定============
            $("#page").on("click", ".next", function(){

                //恢復上一頁的功能
                $(".previous").prop("class", "page-item previous");

                let page = nowPage + 1;

                $(".pageNum").prop("class","page-item page pageNum")
                $("#"+page).prop("class","page-item page pageNum active")

                //計算是否是最後一頁，並取消下一頁功能
                if(page >= (maxPage-1)){
                    $(".next").prop("class", "page-item next disabled")
                    startItem = page * maxItems;
                    endItem = startItem + (memberAll.length % maxItems);
                }else{
                    startItem = page * maxItems;
                    endItem = startItem + maxItems;
                }
                showData(startItem, endItem);
                nowPage = page;
            });











        }
    });


    //顯示資料用
    function showData(startItem,endItem){
        let txt = "<tr>";
        for (let i = startItem; i < endItem; i++) {
            txt += "<td class='align-middle'>"+memberData[i].memberId+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].bkAccount.account+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].memberPic+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].bkAccount.accountStatus+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].memberName+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].memberGender+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].memberCoin+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].discount+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].memberMail+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].memberPhone+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].memberAddress+"</td>"
            txt += "<td class='align-middle'>"+memberData[i].memberBirth+"</td>"
            let newDate = new Date(memberData[i].bkAccount.registerDate);
            let register = newDate.toLocaleString();
            txt += "<td class='align-middle'>"+register+"</td>"
            txt += '<td class="align-middle">'+
                '<form method="post" action="MemUpdate">'+
                '<input type="hidden" type="text" name="memupd" value=?>'+
                '<input id="updateBtn" class="btn btn-outline-primary" type="submit" value="更新">'+
                '</form>'+
                '</td>'
            txt += '<td class="mdata">'+
                '<form method="post" action="">'+
                '<input type="hidden" type="text" name="empdel" value=?>'+
                '<input id="delBtn" class="btn btn-outline-danger" type="button" value="刪除" onclick="">'+
                '</form>'+
                '</td></tr>'
        }
        $("#members").html(txt);
    }





</script>
</body>


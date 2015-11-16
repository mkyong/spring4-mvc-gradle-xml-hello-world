// 검색 
function boardListSearchGo(){
document.listForm.action ="/board/list.html"; 
document.listForm.submit();
} 
  
// 검색Text입력 후 바로 엔터 가능하게 하는 이벤트
function enterEvent(){
if(window.event.keyCode == 13){
boardListSearchGo();
}
}
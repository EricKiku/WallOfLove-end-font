"use strict";(self["webpackChunkapp"]=self["webpackChunkapp"]||[]).push([[659],{5659:function(t,s,e){e.r(s),e.d(s,{default:function(){return p}});var a=function(){var t=this,s=t._self._c;return s("div",[s("van-sticky",[s("van-nav-bar",{staticStyle:{"border-bottom":"0.5px solid rgb(203, 203, 203)"},attrs:{title:"@"+t.postDetails.postNick,"left-text":"返回","left-arrow":""},on:{"click-left":t.onClickLeft},scopedSlots:t._u([{key:"right",fn:function(){return[s("div",{staticClass:"attention"},[s("button",[t._v("关注")])])]},proxy:!0}])})],1),s("div",{ref:"postDetailsTop",staticClass:"post"},[s("div",{staticClass:"userDetails"},[s("div",{staticClass:"touxiang"},[s("van-image",{attrs:{round:"",src:"https://img01.yzcdn.cn/vant/cat.jpeg"}})],1),s("div",{staticClass:"info"},[s("p",[t._v(t._s(t.postDetails.postNick))]),s("p",{staticClass:"little"},[t._v(" "+t._s(t.postDetails.postDate)+" · "+t._s(t.postDetails.postReadcount)+"次浏览 ")])]),s("div",[t._v("…")])]),s("div",{staticClass:"content"},[t._v(" "+t._s(t.postDetails.postContent)+" ")])]),s("div",{staticClass:"postComment"},[s("p",{staticStyle:{"text-align":"left",padding:"10px 0px 10px 10px"}},[t._v("评论")]),t._l(t.commentList,(function(e){return s("div",{key:e.commentId,staticClass:"commentItem"},[s("div",{staticClass:"touxiang"},[s("van-image",{attrs:{round:"",src:"https://img01.yzcdn.cn/vant/cat.jpeg"}})],1),s("div",{staticClass:"comment"},[s("div",{staticClass:"info"},[t._v(" "+t._s(e.userNick)+"   ·   "+t._s(e.commentDate)+" ")]),s("div",{staticClass:"txt"},[t._v(t._s(e.commentContent))])])])})),s("div",{staticClass:"writeComment"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.MyComment,expression:"MyComment"}],attrs:{type:"text"},domProps:{value:t.MyComment},on:{input:function(s){s.target.composing||(t.MyComment=s.target.value)}}}),s("span",{staticClass:"put",on:{click:t.putMyComment}},[t._v("发布")]),s("span",{staticClass:"userLike"},[s("van-icon",{attrs:{name:"thumb-circle-o"}}),t._v("  "+t._s(t.postDetails.postLike)+" ")],1)])],2)],1)},i=[],n=e(5101),o=e(3822),c={name:"PostDetails",data(){return{postDetails:"",MyComment:"",commentList:[]}},computed:{...(0,o.rn)(["token","userAccount"])},methods:{onClickLeft(){this.$router.go(-1)},onClickRight(){console.log("关注")},putMyComment(){(0,n.zE)(this.token).then((t=>{(0,n.du)({userAccount:this.userAccount,MyComment:this.MyComment,postId:this.postDetails.postId,date:this.getDate(),reply:0}).then((t=>{this.refreshComment(),this.$toast.success("评论成功"),this.MyComment="",(0,n.Ir)(this.postDetails.postId)}),(t=>{this.$toast.fail("服务器异常")}))}),(t=>{this.$toast.fail("服务器异常")}))},getDate(){let t=(new Date).getFullYear(),s=(new Date).getMonth()+1,e=(new Date).getDate(),a=(new Date).getHours(),i=(new Date).getMinutes(),n=(new Date).getSeconds();a<10&&(a="0"+a),i<10&&(i="0"+i),n<10&&(n="0"+n);let o=t+"-"+s+"-"+e+" "+a+":"+i+":"+n;return o},async refreshComment(){await(0,n.d7)(this.postDetails.postId).then((t=>{this.commentList=t.reverse()}),(t=>{this.$toast.fail("服务器异常")}))}},async mounted(){let t=this.$route.query.postId;await(0,n.vs)(t).then((t=>{this.postDetails=t})),this.refreshComment()},components:{}},l=c,r=e(1001),m=(0,r.Z)(l,a,i,!1,null,null,null),p=m.exports}}]);
//# sourceMappingURL=659.dd080adc.js.map
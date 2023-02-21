//package xyz.erickiku.demo2.controller;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import xyz.erickiku.demo2.mapper.ListMapper;
//import xyz.erickiku.demo2.pojo.List;
//
//@RestController
//public class ListController {
//    @Autowired
//    private ListMapper listMapper;
//
//    //用户提交货单接口
//    @PostMapping("/insertList")
//    public String insert(@RequestBody List list){
//        System.out.println("@"+list);
//        int i = listMapper.insert(list);
//        if (i > 0){
//            return "提交成功";
//        }else{
//            return "提交失败";
//        }
//    }
//
//    //用于查询货单接口
//    @GetMapping("/queryAllList")
//    public IPage queryAll(Integer pageNum){
//        Page<List> page = new Page<>(pageNum,50);
//        IPage iPage = listMapper.selectPage(page,new QueryWrapper<List>()
//                .orderByDesc("id")
//        );
//        return iPage;
//    }
//
//
//    @PostMapping("/updateById")
//    public String updataById(@RequestBody List list){
//        int i = listMapper.updateById(list);
//        return "更新成功";
//    }
//
//    @GetMapping("/deleteById")
//    public int delete(Integer id){
//        int i = listMapper.deleteById(id);
//        return i;
//    }
//
//    @GetMapping("/selectSearch")
//    public java.util.List<List> selectSearch(String searchValue){
//        java.util.List<List> lists = listMapper.selectSearch(searchValue);
//        return lists;
//    }
//
//    @GetMapping("/queryAllDate")
//    public java.util.List queryAllDate(){
//        java.util.List list = listMapper.queryAllDate();
//        return list;
//    }
//
//
//    //根据关键字和值查询
//    @GetMapping("/queryByKeyAndValue")
//    public java.util.List queryByKeyAndValue(String searchKey,String searchValue,String beforeDate,String newDate){
//        java.util.List list = null;
//        System.out.println(searchKey.equals("receive_info"));
//        if (searchKey.equals("receive_info")){
//            list = listMapper.queryReceiveAndValue(searchValue,beforeDate,newDate);
//        }else if (searchKey.equals("send_info")){
//            list = listMapper.querySendAndValue(searchValue,beforeDate,newDate);
//        }
//
//        return list;
//    }
//
//}

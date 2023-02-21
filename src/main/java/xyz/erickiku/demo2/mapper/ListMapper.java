//package xyz.erickiku.demo2.mapper;
//
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;
//import xyz.erickiku.demo2.pojo.List;
//
//@Mapper
//public interface ListMapper extends BaseMapper<List> {
//
//
//    //搜索，查找所有字段对应值的数据
//    @Select("SELECT * FROM `list` WHERE LOCAL = #{searchValue} OR send_info = #{searchValue} OR receive_info = #{searchValue} OR date = #{searchValue} OR money = #{searchValue} ORDER BY id DESC")
//    java.util.List<List> selectSearch(String searchValue);
//
//    //获取所有的日期
//    @Select("SELECT DATE FROM `list` GROUP BY DATE ORDER BY DATE DESC")
//    java.util.List<String> queryAllDate();
//
//
//    //根据关键字和值查询
//    @Select("SELECT * FROM `list` WHERE receive_info = #{searchValue} AND (date = #{beforeDate} OR date = #{newDate}) ORDER BY id DESC")
//    java.util.List<List> queryReceiveAndValue(String searchValue,String beforeDate,String newDate);
//    @Select("SELECT * FROM `list` WHERE send_info = #{searchValue} AND (date = #{beforeDate} OR date = #{newDate}) ORDER BY id DESC")
//    java.util.List<List> querySendAndValue(String searchValue,String beforeDate,String newDate);
//}

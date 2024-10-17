package nus.iss.ais.petoria.mapper;

import java.util.List;
import nus.iss.ais.petoria.model.PictureEvaluation;
import nus.iss.ais.petoria.model.PictureEvaluationExample;
import org.apache.ibatis.annotations.Param;

public interface PictureEvaluationMapper {
    long countByExample(PictureEvaluationExample example);

    int deleteByExample(PictureEvaluationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PictureEvaluation row);

    int insertSelective(PictureEvaluation row);

    List<PictureEvaluation> selectByExample(PictureEvaluationExample example);

    PictureEvaluation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") PictureEvaluation row, @Param("example") PictureEvaluationExample example);

    int updateByExample(@Param("row") PictureEvaluation row, @Param("example") PictureEvaluationExample example);

    int updateByPrimaryKeySelective(PictureEvaluation row);

    int updateByPrimaryKey(PictureEvaluation row);
}
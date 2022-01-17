package foodelicious.article.repository;

import java.util.List;
import java.util.Map;

import foodelicious.article.model.MsgArea;

public interface MsgRepository {

	void insertMsg(Map<String, String> params);

	List<MsgArea> useIdFindAllMSG(Integer articleId);

}

package foodelicious.article.service;

import java.util.List;
import java.util.Map;

import foodelicious.article.model.MsgArea;

public interface MsgService {

	void insertMsg(Map<String, String> params);

	List<MsgArea> useIdFindAllMSG(Integer articleId);

	void likeOrNot(Map<String, String> params);

}

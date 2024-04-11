package service;

import model.ChatLieu;
import java.util.List;

public interface ChatLieuService {

    List<ChatLieu> getChatLieu();

    public boolean add(ChatLieu cl);

    public boolean deletecl(ChatLieu cl);

    public boolean deletecl(int idChatLieu);

   public void suaChatLieu(ChatLieu cl);

   

}

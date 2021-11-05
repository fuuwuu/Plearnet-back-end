package tw.edu.ntub.imd.plearnet.service.impl;

import tw.edu.ntub.imd.plearnet.bean.MessageBean;
import tw.edu.ntub.imd.plearnet.databaseconfig.dao.MessageDAO;
import tw.edu.ntub.imd.plearnet.databaseconfig.entity.Message;
import tw.edu.ntub.imd.plearnet.service.MessageService;
import tw.edu.ntub.imd.plearnet.service.transformer.MessageTransformer;

import java.util.List;
import java.util.Optional;

public class MessageServiceImpl extends BaseServiceImpl<MessageBean, Message, String> implements MessageService {
    private final MessageDAO messageDAO;
    private final MessageTransformer transformer;

    public MessageServiceImpl(MessageDAO messageDAO, MessageTransformer transformer){
        super(messageDAO, transformer);
        this.messageDAO = messageDAO;
        this.transformer = transformer;
    }

    @Override
    public MessageBean save(MessageBean messageBean){
        Message message = messageDAO.save(transformer.transferToEntity(messageBean));
        return transformer.transferToBean(message);
    }

    @Override
    public Optional<MessageBean> getById(Integer id){return Optional.empty(); }

    @Override
    public List<MessageBean> searchAll(Integer id){return null;}

}
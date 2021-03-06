package tos.netty.decoder;

import com.alibaba.fastjson.JSONObject;
import tos.netty.bean.ResponsePlus;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;
import java.util.List;

public class ResponseDecoder extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf msg, List<Object> list) throws Exception {
        String msgStr = msg.toString(Charset.defaultCharset());
        ResponsePlus responsePlus = JSONObject.parseObject(msgStr, ResponsePlus.class);
        list.add(responsePlus);
    }
}

package yi.shi.ssh.service;

import com.jcraft.jsch.Session;
import org.apache.commons.io.IOUtils;
import yi.shi.ssh.model.Request;
import yi.shi.ssh.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import yi.shi.ssh.utils.SshUtil;

import java.io.OutputStream;

@org.springframework.stereotype.Service
@Slf4j
public class Service {

    @Tool(description = "通过ssh连接目标linux服务器，并发送shell命令")
    public Response sendShellCmd(@ToolParam(description = "通过SSH登录linux服务器并发送shell命令，包含ip port user passwd 和 cmd参数")Request request) throws Exception {
        log.info("sendShellCmd request: {}", request);
        Session session = SshUtil.getSession(request.getIp(), request.getUser(), request.getPasswd(), request.getPort());
        String res = SshUtil.exec(session, request.getCmd());
        return new Response(res);
    }



}

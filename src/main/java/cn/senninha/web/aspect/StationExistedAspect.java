package cn.senninha.web.aspect;


import cn.senninha.web.exception.BadReqeuestException;
import cn.senninha.web.service.StationService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StationExistedAspect {
    @Autowired
    private StationService stationService;

    @Before(value = "execution(public * cn.senninha.web.service.EquipmentService.*(..)) && args(stationId)")
    public void beforeAdvice(JoinPoint joinPoint, int stationId) throws BadReqeuestException{
        if(!stationService.isStationExisted(stationId)) {
            throw new BadReqeuestException("ID为 " + String.valueOf(stationId) + " 的充电站不存在");
        }
     }

}

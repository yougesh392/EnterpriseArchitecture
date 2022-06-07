import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
@Transactional
public class CarService {
    @Resource
    private IBookDao carDao;
}

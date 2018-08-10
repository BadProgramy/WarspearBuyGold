package article.example.demo.service;

import article.example.demo.dao.OutbidRepository;
import article.example.demo.model.Outbid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutbidService {

    @Autowired
    private OutbidRepository outbidRepository;

    public Outbid getOutbid(String nameFraction) {
        for (Outbid outbid: outbidRepository.findAll()) {
            if (outbid.getNameFraction().equals(nameFraction))
                return outbid;
        }
        return null;
    }
}

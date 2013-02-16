package org.example.eventsourcing.presentation;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.axonframework.eventhandling.replay.ReplayingCluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/replayAll")
public class ReplayAllController {
    private final ReplayingCluster replayingCluster;

    @Autowired
    public ReplayAllController(ReplayingCluster replayingCluster) {
        this.replayingCluster = replayingCluster;
    }

    @RequestMapping(method = POST)
    public void replayAll() {
        replayingCluster.startReplay();
    }
}
